package kr.pe.afterschool.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import kr.pe.afterschool.domain.user.exception.UserNotFoundException;
import kr.pe.afterschool.global.config.properties.JwtProperties;
import kr.pe.afterschool.global.security.jwt.exception.ExpiredTokenException;
import kr.pe.afterschool.global.security.jwt.exception.InvalidTokenException;
import kr.pe.afterschool.global.security.principle.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@RequiredArgsConstructor
public class JwtTokenParser {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())) {
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        }

        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenBody(token).getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw InvalidTokenException.EXCEPTION;
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        }
    }
}
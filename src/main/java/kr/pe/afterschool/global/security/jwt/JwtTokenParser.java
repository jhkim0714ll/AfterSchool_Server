package kr.pe.afterschool.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import kr.pe.afterschool.global.config.properties.JwtProperties;
import kr.pe.afterschool.global.enums.JWT;
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
                .loadUserByUsername(getTokenBody(token, JWT.ACCESS).getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getKeyByJwt(JWT jwt) {
        return jwt.equals(JWT.ACCESS) ? jwtProperties.getAccessKey() : jwtProperties.getRefreshKey();
    }

    public Claims getTokenBody(String token, JWT jwt) {
        String key = getKeyByJwt(jwt);
        return Jwts.parser().setSigningKey(key)
                .parseClaimsJws(token).getBody();
    }
}
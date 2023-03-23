package kr.pe.afterschool.global.filter;

import io.jsonwebtoken.ExpiredJwtException;
import kr.pe.afterschool.global.security.jwt.JwtTokenParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenParser jwtTokenParser;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String bearer = jwtTokenParser.resolveToken(request);

            if (bearer != null) {
                Authentication authentication = jwtTokenParser.authentication(bearer);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (IllegalArgumentException ex){
            logger.error("Unable to get JWT token", ex);
        } catch (ExpiredJwtException ex){
            logger.error("JWT Token has expired", ex);
        }

        filterChain.doFilter(request, response);
    }
}

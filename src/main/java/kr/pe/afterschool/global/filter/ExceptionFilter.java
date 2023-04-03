package kr.pe.afterschool.global.filter;

import io.jsonwebtoken.ExpiredJwtException;
import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.global.error.exception.InternalServerException;
import kr.pe.afterschool.global.lib.JsonParser;
import kr.pe.afterschool.global.security.jwt.exception.ExpiredTokenException;
import kr.pe.afterschool.global.security.jwt.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {

    private final JsonParser jsonParser;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            jsonParser.errorToJson(ExpiredTokenException.EXCEPTION.getErrorProperty(), response);
        } catch (AfterSchoolException e) {
            jsonParser.errorToJson(e.getErrorProperty(), response);
        } catch (AccessDeniedException e) {
            jsonParser.errorToJson(InvalidTokenException.EXCEPTION.getErrorProperty(), response);
        } catch (Exception e) {
            jsonParser.errorToJson(InternalServerException.EXCEPTION.getErrorProperty(), response);
        }
    }
}

package kr.pe.afterschool.global.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import kr.pe.afterschool.global.error.exception.ErrorProperty;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;
import kr.pe.afterschool.global.error.exception.InternalServerException;
import kr.pe.afterschool.global.response.ResponseError;
import kr.pe.afterschool.global.security.jwt.exception.ExpiredTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            errorToJson(ExpiredTokenException.EXCEPTION.getErrorProperty(), response);
        } catch (AfterSchoolException e) {
            errorToJson(e.getErrorProperty(), response);
        } catch (Exception e) {
            errorToJson(InternalServerException.EXCEPTION.getErrorProperty(), response);
        }
    }

    private void errorToJson(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseError responseError = new ResponseError(HttpStatus.valueOf(errorProperty.getStatus()), errorProperty.getMessage());
        response.getWriter().write(objectMapper.writeValueAsString(responseError));
    }
}

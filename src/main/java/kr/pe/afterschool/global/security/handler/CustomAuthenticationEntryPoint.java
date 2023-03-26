package kr.pe.afterschool.global.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;
import kr.pe.afterschool.global.error.exception.InternalServerException;
import kr.pe.afterschool.global.response.ResponseError;
import kr.pe.afterschool.global.security.jwt.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final AfterSchoolException exceptionResponse =
            InvalidTokenException.EXCEPTION;
    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        try {
            ResponseError responseError = new ResponseError(
                    HttpStatus.valueOf(exceptionResponse.getErrorProperty().getStatus()),
                    exceptionResponse.getErrorProperty().getMessage());
            response.getWriter().write(objectMapper.writeValueAsString(responseError));
        } catch (Exception ex) {
            throw InternalServerException.EXCEPTION;
        }
    }
}

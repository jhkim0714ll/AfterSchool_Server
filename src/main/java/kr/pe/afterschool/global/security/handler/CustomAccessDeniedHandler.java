package kr.pe.afterschool.global.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;
import kr.pe.afterschool.global.error.exception.InternalServerException;
import kr.pe.afterschool.global.error.exception.NoAuthenticationException;
import kr.pe.afterschool.global.response.ResponseError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private static final AfterSchoolException exceptionResponse =
            NoAuthenticationException.EXCEPTION;
    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
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

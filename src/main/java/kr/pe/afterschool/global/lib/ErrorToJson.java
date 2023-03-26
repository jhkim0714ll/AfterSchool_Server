package kr.pe.afterschool.global.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.afterschool.global.error.exception.ErrorProperty;
import kr.pe.afterschool.global.response.ResponseError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ErrorToJson {
    private final ObjectMapper objectMapper;

    public void errorToJson(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseError responseError = new ResponseError(
                HttpStatus.valueOf(errorProperty.getStatus()), errorProperty.getMessage());
        response.getWriter().write(objectMapper.writeValueAsString(responseError));
    }
}

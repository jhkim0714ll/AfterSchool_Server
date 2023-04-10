package kr.pe.afterschool.global.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.afterschool.global.error.ErrorProperty;
import kr.pe.afterschool.global.error.exception.InternalServerException;
import kr.pe.afterschool.global.response.ResponseError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonParser {
    private final ObjectMapper objectMapper;

    public void errorToJson(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseError responseError = new ResponseError(
                HttpStatus.valueOf(errorProperty.getStatus()), errorProperty.getMessage());
        response.getWriter().write(objectMapper.writeValueAsString(responseError));
    }

    public JSONArray StringToJSONArrayOfRow(String originString, String arrayName) {
        try {
            JSONObject object = new JSONObject(originString);

            JSONArray arrayServiceInfo = object.optJSONArray(arrayName);
            JSONObject serviceInfo = arrayServiceInfo.optJSONObject(1);
            return serviceInfo.optJSONArray("row");
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }
}

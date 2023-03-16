package kr.pe.afterschool.global.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseError extends Response {

    @Builder
    public ResponseError(HttpStatus status, String message) {
        super(status, message);
    }
}

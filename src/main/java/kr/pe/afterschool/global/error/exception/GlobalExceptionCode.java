package kr.pe.afterschool.global.error.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GlobalExceptionCode implements ErrorProperty {

    EXPIRED_TOKEN(401, "토큰 만료"),
    INVALID_TOKEN(401, "토큰이 유효하지 않습니다"),
    NO_AUTHENTICATION(403, "권한이 없습니다"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
    ;

    private final int status;
    private final String message;
}

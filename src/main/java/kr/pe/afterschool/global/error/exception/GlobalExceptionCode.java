package kr.pe.afterschool.global.error.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GlobalExceptionCode implements ErrorProperty {

    EXPIRED_TOKEN(401, "Token Expired"),
    INVALID_TOKEN(401, "Token Invalid"),
    NO_AUTHENTICATION(403, "No Authenticate"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
    ;

    private final int status;
    private final String message;
}

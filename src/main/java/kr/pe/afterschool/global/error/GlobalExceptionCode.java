package kr.pe.afterschool.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GlobalExceptionCode implements ErrorProperty {

    DATE_PARSER(400, "잘못된 날짜 형식"),
    EXPIRED_TOKEN(401, "Token Expired"),
    INVALID_TOKEN(401, "Token Invalid"),
    NO_AUTHENTICATION(403, "No Authenticate"),
    ENCODE_FAILED(500, "인코딩 실패"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
    ;

    private final int status;
    private final String message;
}

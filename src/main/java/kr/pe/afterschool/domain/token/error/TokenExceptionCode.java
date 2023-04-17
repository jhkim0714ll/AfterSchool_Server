package kr.pe.afterschool.domain.token.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TokenExceptionCode implements ErrorProperty {

    TOKEN_BAD_REQUEST(400, "토큰이 전달되지 않았습니다");

    private final int status;
    private final String message;
}


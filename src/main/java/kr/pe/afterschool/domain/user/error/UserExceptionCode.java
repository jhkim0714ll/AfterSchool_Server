package kr.pe.afterschool.domain.user.error;

import kr.pe.afterschool.global.error.exception.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserExceptionCode implements ErrorProperty {

    USER_NAME_NOT_FOUND(404, "Username Not found"),
    USER_NOT_FOUND(404, "해당 유저는 존재하지 않습니다")
    ;

    private final int status;
    private final String message;
}

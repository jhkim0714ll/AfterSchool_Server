package kr.pe.afterschool.domain.school.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SchoolExceptionCode implements ErrorProperty {

    SCHOOL_NOT_FOUNT(404, "해당 학교는 존재하지 않습니다")
    ;

    private final int status;
    private final String message;
}

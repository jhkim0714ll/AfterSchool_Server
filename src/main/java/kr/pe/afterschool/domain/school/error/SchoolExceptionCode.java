package kr.pe.afterschool.domain.school.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SchoolExceptionCode implements ErrorProperty {

    SCHOOL_ALREADY_EXIST(403, "이미 같은 학교가 존재합니다"),
    SCHOOL_CANNOT_MANAGE(403, "해당 학교를 관리할 수 없습니다"),
    SCHOOL_NOT_FOUNT(404, "해당 학교는 존재하지 않습니다"),
    ;

    private final int status;
    private final String message;
}

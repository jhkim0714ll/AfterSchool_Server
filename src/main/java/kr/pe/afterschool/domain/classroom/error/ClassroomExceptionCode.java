package kr.pe.afterschool.domain.classroom.error;

import kr.pe.afterschool.global.error.exception.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ClassroomExceptionCode implements ErrorProperty {

    CLASSROOM_NOT_FOUND(404, "해당 방과후가 존재하지 않음");

    private final int status;
    private final String message;
}

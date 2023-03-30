package kr.pe.afterschool.domain.classroom.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ClassroomExceptionCode implements ErrorProperty {

    CLASSROOM_CANNOT_MANAGE(403, "방과후를 관리할 수 없음"),
    CLASSROOM_NOT_FOUND(404, "해당 방과후가 존재하지 않음"),
    CLASSROOM_APPLY_NOT_FOUND(404, "해당 방과후 신청 내역이 존재하지 않음")
    ;

    private final int status;
    private final String message;
}

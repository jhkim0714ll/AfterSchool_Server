package kr.pe.afterschool.domain.apply.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApplyExceptionCode implements ErrorProperty {

    CLASSROOM_ALREADY_DECISION(403, "이미 결정되어 변경 불가"),
    CLASSROOM_TIME_OVER(403, "시간이 초과되어 방과후를 신청할 수 없음"),
    CLASSROOM_PEOPLE_OVER(403, "인원이 초과되어 방과후를 신청할 수 없음"),
    APPLY_NOT_FOUND(404, "해당 방과후 신청 내역이 존재하지 않음")
    ;

    private final int status;
    private final String message;
}


package kr.pe.afterschool.domain.classroom.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomDecisionRequest {

    @NotNull(message = "classroomId must not null")
    private Long classroomId;
    @NotNull(message = "peopleLimit must not null")
    private int peopleLimit;
}

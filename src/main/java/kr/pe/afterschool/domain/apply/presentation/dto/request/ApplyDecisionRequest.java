package kr.pe.afterschool.domain.apply.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplyDecisionRequest {

    @NotNull(message = "classroomId must not null")
    private Long classroomId;
    @NotNull(message = "peopleLimit must not null")
    private int peopleLimit;
}

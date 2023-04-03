package kr.pe.afterschool.domain.apply.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplyCreateRequest {

    @NotNull(message = "classroomId must not null")
    private Long classroomId;
}

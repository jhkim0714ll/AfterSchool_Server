package kr.pe.afterschool.domain.survey.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionCreateRequest {

    @NotNull(message = "questions must not null")
    private List<String> questions;
    @NotNull(message = "classroomId must not null")
    private Long classroomId;
}

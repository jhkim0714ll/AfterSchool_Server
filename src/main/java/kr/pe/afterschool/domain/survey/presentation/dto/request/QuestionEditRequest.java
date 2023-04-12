package kr.pe.afterschool.domain.survey.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionEditRequest {

    private List<String> questions;
}

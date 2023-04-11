package kr.pe.afterschool.domain.survey.presentation.dto.response;

import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import kr.pe.afterschool.domain.survey.entity.Question;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionResponse {

    private Long questionId;
    private String[] questions;
    private SchoolResponse school;

    public QuestionResponse(Question question) {
        this.questionId = question.getId();
        this.questions = question.getQuestions().split("::");
        this.school = new SchoolResponse(question.getSchool());
    }
}

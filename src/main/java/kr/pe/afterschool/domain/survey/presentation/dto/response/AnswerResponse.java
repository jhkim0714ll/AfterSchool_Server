package kr.pe.afterschool.domain.survey.presentation.dto.response;

import kr.pe.afterschool.domain.survey.entity.Answer;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerResponse {

    private Long surveyId;
    private String[] content;
    private UserResponse student;
    private QuestionResponse question;

    public AnswerResponse(Answer answer) {
        this.surveyId = answer.getId();
        this.content = answer.getAnswer().split("::");
        this.student = new UserResponse(answer.getStudent());
        this.question = new QuestionResponse(answer.getQuestion());
    }
}

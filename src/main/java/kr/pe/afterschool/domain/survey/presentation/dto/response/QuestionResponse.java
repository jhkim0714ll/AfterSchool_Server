package kr.pe.afterschool.domain.survey.presentation.dto.response;

import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.survey.entity.Question;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionResponse {

    private Long questionId;
    private String[] questions;
    private ClassroomResponse classroomResponse;

    public QuestionResponse(Question question) {
        this.questionId = question.getId();
        this.questions = question.getQuestions().split("::");
        this.classroomResponse = new ClassroomResponse(question.getClassroom());
    }
}

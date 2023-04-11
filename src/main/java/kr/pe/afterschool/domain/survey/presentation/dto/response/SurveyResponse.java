package kr.pe.afterschool.domain.survey.presentation.dto.response;

import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.survey.entity.Survey;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyResponse {

    private Long surveyId;
    private String[] content;
    private UserResponse student;
    private ClassroomResponse classroom;

    public SurveyResponse(Survey survey) {
        this.surveyId = survey.getId();
        this.content = survey.getContent().split(":..");
        this.student = new UserResponse(survey.getStudent());
        this.classroom = new ClassroomResponse(survey.getClassroom());
    }
}

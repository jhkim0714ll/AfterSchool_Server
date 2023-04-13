package kr.pe.afterschool.domain.survey.service;

<<<<<<< Updated upstream:src/main/java/kr/pe/afterschool/domain/survey/service/SurveyCreateService.java
import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.survey.entity.Survey;
import kr.pe.afterschool.domain.survey.entity.repository.SurveyRepository;
import kr.pe.afterschool.domain.survey.presentation.dto.request.SurveyCreateRequest;
=======
import kr.pe.afterschool.domain.survey.entity.Answer;
import kr.pe.afterschool.domain.survey.entity.Question;
import kr.pe.afterschool.domain.survey.entity.repository.AnswerRepository;
import kr.pe.afterschool.domain.survey.entity.repository.QuestionRepository;
import kr.pe.afterschool.domain.survey.exception.QuestionNotFoundException;
import kr.pe.afterschool.domain.survey.presentation.dto.request.AnswerCreateRequest;
>>>>>>> Stashed changes:src/main/java/kr/pe/afterschool/domain/survey/service/SurveyAnswerCreateService.java
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyCreateService {

    private final SurveyRepository surveyRepository;
    private final ClassroomRepository classroomRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(SurveyCreateRequest request) {
        User user = userFacade.getCurrentUser();

        String contents = request.getContent()
                .stream().map(String::valueOf).collect(Collectors.joining("::"));

        Classroom classroom = classroomRepository.findById(request.getClassroomId())
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);

        Survey survey = Survey.builder()
                .content(contents)
                .classroom(classroom)
                .student(user)
                .build();
        surveyRepository.save(survey);
    }
}

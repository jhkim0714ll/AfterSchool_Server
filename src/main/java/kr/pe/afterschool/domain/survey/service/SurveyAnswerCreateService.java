package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.survey.entity.Answer;
import kr.pe.afterschool.domain.survey.entity.repository.AnswerRepository;
import kr.pe.afterschool.domain.survey.presentation.dto.request.AnswerCreateRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyAnswerCreateService {

    private final AnswerRepository answerRepository;
    private final ClassroomRepository classroomRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(AnswerCreateRequest request) {
        User user = userFacade.getCurrentUser();

        String answers = request.getAnswers()
                .stream().map(String::valueOf).collect(Collectors.joining("::"));

        Classroom classroom = classroomRepository.findById(request.getClassroomId())
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);

        Answer answer = Answer.builder()
                .answer(answers)
                .classroom(classroom)
                .student(user)
                .build();
        answerRepository.save(answer);
    }
}

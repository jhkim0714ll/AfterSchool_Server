package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.survey.entity.Question;
import kr.pe.afterschool.domain.survey.entity.repository.QuestionRepository;
import kr.pe.afterschool.domain.survey.exception.QuestionCannotManageException;
import kr.pe.afterschool.domain.survey.presentation.dto.request.QuestionCreateRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyQuestionCreateService {

    private final QuestionRepository questionRepository;
    private final ClassroomRepository classroomRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(QuestionCreateRequest request) {
        User user = userFacade.getCurrentUser();
        Classroom classroom = classroomRepository.findById(request.getClassroomId())
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);

        if (user != classroom.getSchool().getTeacher()) {
            throw QuestionCannotManageException.EXCEPTION;
        }

        String questions = request.getQuestions()
                .stream().map(String::valueOf).collect(Collectors.joining("::"));

        Question question = Question.builder()
                .questions(questions)
                .classroom(classroom)
                .build();
        questionRepository.save(question);
    }
}

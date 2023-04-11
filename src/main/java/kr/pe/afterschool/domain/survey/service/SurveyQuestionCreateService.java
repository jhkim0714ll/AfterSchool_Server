package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.Question;
import kr.pe.afterschool.domain.survey.entity.repository.QuestionRepository;
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
    private final UserFacade userFacade;

    @Transactional
    public void execute(QuestionCreateRequest request) {
        User user = userFacade.getCurrentUser();

        String questions = request.getQuestions()
                .stream().map(String::valueOf).collect(Collectors.joining("::"));

        Question question = Question.builder()
                .questions(questions)
                .school(user.getSchool())
                .build();
        questionRepository.save(question);
    }
}

package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.Answer;
import kr.pe.afterschool.domain.survey.entity.Question;
import kr.pe.afterschool.domain.survey.entity.repository.AnswerRepository;
import kr.pe.afterschool.domain.survey.entity.repository.QuestionRepository;
import kr.pe.afterschool.domain.survey.exception.QuestionNotFoundException;
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
    private final QuestionRepository questionRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(AnswerCreateRequest request) {
        User user = userFacade.getCurrentUser();

        String answers = request.getAnswers()
                .stream().map(String::valueOf).collect(Collectors.joining("::"));

        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> QuestionNotFoundException.EXCEPTION);

        Answer answer = Answer.builder()
                .answer(answers)
                .question(question)
                .student(user)
                .build();
        answerRepository.save(answer);
    }
}

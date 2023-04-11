package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.Question;
import kr.pe.afterschool.domain.survey.entity.repository.QuestionRepository;
import kr.pe.afterschool.domain.survey.exception.QuestionCannotManageException;
import kr.pe.afterschool.domain.survey.exception.QuestionNotFoundException;
import kr.pe.afterschool.domain.survey.presentation.dto.request.QuestionEditRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyQuestionEditService {

    private final QuestionRepository questionRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long questionId, QuestionEditRequest request) {
        User user = userFacade.getCurrentUser();
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> QuestionNotFoundException.EXCEPTION);
        if (user.getSchool() != question.getClassroom()) {
            throw QuestionCannotManageException.EXCEPTION;
        }
        String questions = request.getQuestions()
                .stream().map(String::valueOf).collect(Collectors.joining("::"));
        question.editQuestion(questions);
        questionRepository.save(question);
    }
}

package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.Answer;
import kr.pe.afterschool.domain.survey.entity.repository.AnswerRepository;
import kr.pe.afterschool.domain.survey.exception.SurveyCannotManageException;
import kr.pe.afterschool.domain.survey.exception.SurveyNotFoundException;
import kr.pe.afterschool.domain.survey.presentation.dto.request.AnswerEditRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyAnswerEditService {

    private final AnswerRepository answerRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long surveyId, AnswerEditRequest request) {
        User user = userFacade.getCurrentUser();
        Answer answer = answerRepository.findById(surveyId)
                .orElseThrow(() -> SurveyNotFoundException.EXCEPTION);
        if (user != answer.getStudent()) {
            throw SurveyCannotManageException.EXCEPTION;
        }

        String contents = request.getContent()
                .stream().map(String::valueOf).collect(Collectors.joining("::"));
        answer.editSurvey(contents);
        answerRepository.save(answer);
    }
}

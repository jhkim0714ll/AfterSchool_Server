package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.Survey;
import kr.pe.afterschool.domain.survey.entity.repository.SurveyRepository;
import kr.pe.afterschool.domain.survey.exception.SurveyCannotManageException;
import kr.pe.afterschool.domain.survey.exception.SurveyNotFoundException;
import kr.pe.afterschool.domain.survey.presentation.dto.request.SurveyEditRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyEditService {

    private final SurveyRepository surveyRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long surveyId, SurveyEditRequest request) {
        User user = userFacade.getCurrentUser();
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> SurveyNotFoundException.EXCEPTION);
        if (user != survey.getStudent()) {
            throw SurveyCannotManageException.EXCEPTION;
        }

        String contents = request.getContent()
                .stream().map(String::valueOf).collect(Collectors.joining("::"));
        survey.editSurvey(contents);
        surveyRepository.save(survey);
    }
}

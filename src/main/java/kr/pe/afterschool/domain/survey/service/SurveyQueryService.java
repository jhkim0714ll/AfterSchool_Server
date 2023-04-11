package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.repository.SurveyRepository;
import kr.pe.afterschool.domain.survey.exception.SurveyNotFoundException;
import kr.pe.afterschool.domain.survey.presentation.dto.response.SurveyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SurveyQueryService {

    private final SurveyRepository surveyRepository;

    @Transactional(readOnly = true)
    public SurveyResponse execute(Long surveyId) {
        return new SurveyResponse(
                surveyRepository.findById(surveyId)
                .orElseThrow(() -> SurveyNotFoundException.EXCEPTION)
        );
    }
}

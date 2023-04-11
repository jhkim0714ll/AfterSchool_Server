package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.repository.AnswerRepository;
import kr.pe.afterschool.domain.survey.exception.SurveyNotFoundException;
import kr.pe.afterschool.domain.survey.presentation.dto.response.AnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SurveyQueryService {

    private final AnswerRepository answerRepository;

    @Transactional(readOnly = true)
    public AnswerResponse execute(Long surveyId) {
        return new AnswerResponse(
                answerRepository.findById(surveyId)
                .orElseThrow(() -> SurveyNotFoundException.EXCEPTION)
        );
    }
}

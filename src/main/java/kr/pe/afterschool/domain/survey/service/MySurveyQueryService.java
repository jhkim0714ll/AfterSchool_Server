package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.repository.SurveyRepository;
import kr.pe.afterschool.domain.survey.presentation.dto.response.SurveyResponse;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MySurveyQueryService {

    private final SurveyRepository surveyRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<SurveyResponse> execute() {
        User user = userFacade.getCurrentUser();
        return surveyRepository.findByStudent(user)
                .stream().map(SurveyResponse::new).collect(Collectors.toList());
    }
}

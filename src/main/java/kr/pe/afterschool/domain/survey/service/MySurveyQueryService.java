package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.survey.entity.repository.AnswerRepository;
import kr.pe.afterschool.domain.survey.presentation.dto.response.AnswerResponse;
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

    private final AnswerRepository answerRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<AnswerResponse> execute() {
        User user = userFacade.getCurrentUser();
        return answerRepository.findByStudent(user)
                .stream().map(AnswerResponse::new).collect(Collectors.toList());
    }
}

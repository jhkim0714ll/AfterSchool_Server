package kr.pe.afterschool.domain.apply.service;

import kr.pe.afterschool.domain.apply.entity.repository.ApplyRepository;
import kr.pe.afterschool.domain.apply.presentation.dto.response.ApplyResponse;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyApplyQueryService {

    private final ApplyRepository applyRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<ApplyResponse> execute() {
        User user = userFacade.getCurrentUser();
        return applyRepository.findByStudent(user)
                .stream().map(ApplyResponse::new).collect(Collectors.toList());
    }
}

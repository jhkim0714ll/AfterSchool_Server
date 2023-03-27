package kr.pe.afterschool.domain.user.service;

import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyUserQueryService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public UserResponse execute() {
        return new UserResponse(
                userFacade.getCurrentUser());
    }
}

package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MySchoolQueryService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public SchoolResponse execute() {
        User user = userFacade.getCurrentUser();
        return new SchoolResponse(user.getSchool());
    }
}

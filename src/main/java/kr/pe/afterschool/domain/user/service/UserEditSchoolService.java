package kr.pe.afterschool.domain.user.service;

import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.domain.user.presentation.dto.request.UserEditSchoolRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserEditSchoolService {

    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(UserEditSchoolRequest request) {
        User user = userFacade.getCurrentUser();
        School school = schoolRepository.findById(request.getSchoolId())
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);
        user.editSchool(school);
        userRepository.save(user);
    }
}

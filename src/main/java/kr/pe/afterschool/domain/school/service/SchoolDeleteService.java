package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolCannotException;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.global.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SchoolDeleteService {

    private final SchoolRepository schoolRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long schoolId) {
        User user = userFacade.getCurrentUser();
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);
        if (!(user == school.getTeacher()) || user.getRole().equals(UserRole.ADMIN)) {
            throw SchoolCannotException.EXCEPTION;
        }
        schoolRepository.delete(school);
    }
}

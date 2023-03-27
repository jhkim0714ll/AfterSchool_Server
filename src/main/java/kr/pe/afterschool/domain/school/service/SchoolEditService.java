package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.*;
import kr.pe.afterschool.domain.school.presentation.dto.request.SchoolEditRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SchoolEditService {

    private final SchoolRepository schoolRepository;

    @Transactional
    public void execute(Long schoolId, SchoolEditRequest request) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);
        school.editSchoolData(
                request.getName() == null ? school.getName() : request.getName(),
                request.getAddress() == null ? school.getAddress() : request.getAddress(),
                request.getHomePage() == null ? school.getHomePage() : request.getHomePage(),
                request.getPhone() == null ? school.getPhone() : request.getPhone());
        schoolRepository.save(school);
    }
}

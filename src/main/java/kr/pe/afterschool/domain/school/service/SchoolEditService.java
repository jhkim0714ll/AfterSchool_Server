package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.domain.school.presentation.dto.request.SchoolEditRequest;
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
                request.getName(),
                request.getAddress(),
                request.getHomePage(),
                request.getPhone());
        schoolRepository.save(school);
    }
}

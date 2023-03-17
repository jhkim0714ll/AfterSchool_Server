package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetSchoolByIdService {

    private final SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    public SchoolResponse execute(Long id) {
        return new SchoolResponse(schoolRepository.findById(id)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION));
    }
}

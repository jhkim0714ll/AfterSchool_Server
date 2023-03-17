package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSchoolByIdService {

    private final SchoolRepository schoolRepository;

    public SchoolResponse execute(Long id) {
        return new SchoolResponse(schoolRepository.findById(id)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION));
    }
}

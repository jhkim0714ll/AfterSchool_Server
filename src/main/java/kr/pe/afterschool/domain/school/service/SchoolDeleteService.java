package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SchoolDeleteService {

    private final SchoolRepository schoolRepository;

    @Transactional
    public void execute(Long schoolId) {
        schoolRepository.deleteById(schoolId);
    }
}

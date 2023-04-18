package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchoolSearchQueryService {

    private final SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    public List<SchoolResponse> execute(String address, String name) {
        List<School> school = !address.equals("") ?
                schoolRepository.findByAddressContaining(address) :
                schoolRepository.findByNameContaining(name);
        return school.stream().map(SchoolResponse::new).collect(Collectors.toList());
    }
}

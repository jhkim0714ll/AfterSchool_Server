package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolByCityQueryService {

    private final SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    public List<SchoolResponse> execute(String address) {
        return schoolRepository.findByAddressContaining(address)
                .stream().map(SchoolResponse::new).collect(Collectors.toList());
    }
}

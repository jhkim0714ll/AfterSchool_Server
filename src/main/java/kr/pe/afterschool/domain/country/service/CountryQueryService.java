package kr.pe.afterschool.domain.country.service;

import kr.pe.afterschool.domain.country.entity.repository.CountryRepository;
import kr.pe.afterschool.domain.country.presentation.dto.response.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryQueryService {

    private final CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<CountryResponse> execute() {
        return countryRepository.findAll()
                .stream().map(CountryResponse::new).collect(Collectors.toList());
    }
}

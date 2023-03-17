package kr.pe.afterschool.domain.country.service;

import kr.pe.afterschool.domain.country.entity.Country;
import kr.pe.afterschool.domain.country.entity.repository.CountryRepository;
import kr.pe.afterschool.domain.country.exception.CountryAlreadyExistException;
import kr.pe.afterschool.domain.country.presentation.dto.request.CountryCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryCreateService {

    private final CountryRepository countryRepository;

    @Transactional
    public void execute(CountryCreateRequest request) {
        if (countryRepository.existsByName(request.getName())) {
            throw CountryAlreadyExistException.EXCEPTION;
        }
        Country country = Country.builder()
                .name(request.getName())
                .build();
        countryRepository.save(country);
    }
}

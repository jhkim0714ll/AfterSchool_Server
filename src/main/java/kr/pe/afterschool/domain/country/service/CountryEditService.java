package kr.pe.afterschool.domain.country.service;

import kr.pe.afterschool.domain.country.entity.Country;
import kr.pe.afterschool.domain.country.entity.repository.CountryRepository;
import kr.pe.afterschool.domain.country.exception.CountryNotFoundException;
import kr.pe.afterschool.domain.country.presentation.dto.request.CountryEditRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryEditService {

    private final CountryRepository countryRepository;

    @Transactional
    public void execute(Long countryId, CountryEditRequest request) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> CountryNotFoundException.EXCEPTION);
        country.editCountry(request.getName());
        countryRepository.save(country);
    }
}

package kr.pe.afterschool.domain.city.service;

import kr.pe.afterschool.domain.city.entity.Country;
import kr.pe.afterschool.domain.city.entity.repository.CityRepository;
import kr.pe.afterschool.domain.city.entity.repository.CountryRepository;
import kr.pe.afterschool.domain.city.exception.CountryNotFoundException;
import kr.pe.afterschool.domain.city.presentation.dto.response.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitiesByCountryQueryService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<CityResponse> execute(Long countryId) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> CountryNotFoundException.EXCEPTION);
        return cityRepository.findByCountry(country)
                .stream().map(CityResponse::new).collect(Collectors.toList());
    }
}

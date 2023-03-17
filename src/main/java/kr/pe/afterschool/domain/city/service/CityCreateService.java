package kr.pe.afterschool.domain.city.service;

import kr.pe.afterschool.domain.city.entity.City;
import kr.pe.afterschool.domain.city.entity.repository.CityRepository;
import kr.pe.afterschool.domain.city.exception.CityAlreadyExistException;
import kr.pe.afterschool.domain.city.presentation.dto.request.CityCreateRequest;
import kr.pe.afterschool.domain.country.entity.Country;
import kr.pe.afterschool.domain.country.entity.repository.CountryRepository;
import kr.pe.afterschool.domain.country.exception.CountryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CityCreateService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Transactional
    public void execute(CityCreateRequest request) {
        if (cityRepository.existsByName(request.getName())) {
            throw CityAlreadyExistException.EXCEPTION;
        }
        Country country = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> CountryNotFoundException.EXCEPTION);
        City city = City.builder()
                .name(request.getName())
                .country(country)
                .build();
        cityRepository.save(city);
    }
}

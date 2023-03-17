package kr.pe.afterschool.domain.city.service;

import kr.pe.afterschool.domain.city.entity.City;
import kr.pe.afterschool.domain.city.entity.repository.CityRepository;
import kr.pe.afterschool.domain.city.exception.CityNotFoundException;
import kr.pe.afterschool.domain.city.presentation.dto.request.CityEditRequest;
import kr.pe.afterschool.domain.country.entity.Country;
import kr.pe.afterschool.domain.country.entity.repository.CountryRepository;
import kr.pe.afterschool.domain.country.exception.CountryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CityEditService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Transactional
    public void execute(Long cityId, CityEditRequest request) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> CityNotFoundException.EXCEPTION);
        Country country = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> CountryNotFoundException.EXCEPTION);
        city.editCity(request.getName(), country);
        cityRepository.save(city);
    }
}

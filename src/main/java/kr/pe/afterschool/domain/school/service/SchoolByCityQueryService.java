package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.school.entity.City;
import kr.pe.afterschool.domain.school.entity.Country;
import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.CityRepository;
import kr.pe.afterschool.domain.school.entity.repository.CountryRepository;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.CityNotFoundException;
import kr.pe.afterschool.domain.school.exception.CountryNotFoundException;
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
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<SchoolResponse> execute(String cityName, String countryName) {
        City city = cityRepository.findByName(cityName)
                .orElseThrow(() -> CityNotFoundException.EXCEPTION);
        Country country = countryRepository.findByName(countryName)
                .orElseThrow(() -> CountryNotFoundException.EXCEPTION);
        return schoolRepository.findByCityAndCountry(city, country)
                .stream().map(SchoolResponse::new).collect(Collectors.toList());
    }
}

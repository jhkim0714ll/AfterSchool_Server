package kr.pe.afterschool.domain.school.service;

import kr.pe.afterschool.domain.city.entity.City;
import kr.pe.afterschool.domain.country.entity.Country;
import kr.pe.afterschool.domain.city.entity.repository.CityRepository;
import kr.pe.afterschool.domain.country.entity.repository.CountryRepository;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.city.exception.CityNotFoundException;
import kr.pe.afterschool.domain.country.exception.CountryNotFoundException;
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

    @Transactional(readOnly = true)
    public List<SchoolResponse> execute(String cityName) {
        City city = cityRepository.findByName(cityName)
                .orElseThrow(() -> CityNotFoundException.EXCEPTION);
        return schoolRepository.findByCity(city)
                .stream().map(SchoolResponse::new).collect(Collectors.toList());
    }
}

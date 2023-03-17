package kr.pe.afterschool.domain.city.service;

import kr.pe.afterschool.domain.city.entity.repository.CityRepository;
import kr.pe.afterschool.domain.city.presentation.dto.response.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitiesQueryService {

    private final CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityResponse> execute() {
        return cityRepository.findAll()
                .stream().map(CityResponse::new).collect(Collectors.toList());
    }
}

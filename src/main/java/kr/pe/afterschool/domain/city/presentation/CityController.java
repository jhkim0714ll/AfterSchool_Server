package kr.pe.afterschool.domain.city.presentation;

import kr.pe.afterschool.domain.city.presentation.dto.response.CityResponse;
import kr.pe.afterschool.domain.city.presentation.dto.response.CountryResponse;
import kr.pe.afterschool.domain.city.service.CitiesByCountryQueryService;
import kr.pe.afterschool.domain.city.service.CitiesQueryService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CitiesQueryService citiesQueryService;
    private final CitiesByCountryQueryService citiesByCountryQueryService;

    @GetMapping
    public ResponseData<List<CityResponse>> getCities() {
        List<CityResponse> response = citiesQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "모든 도시 조회 성공",
                response
        );
    }

    @GetMapping("/country/{countryId}")
    public ResponseData<List<CityResponse>> getCitiesByCountry(
            @PathVariable Long countryId
    ) {
        List<CityResponse> response = citiesByCountryQueryService.execute(countryId);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 행정구역의 도시 조회 성공",
                response
        );
    }
}

package kr.pe.afterschool.domain.country.presentation;

import kr.pe.afterschool.domain.country.presentation.dto.response.CountryResponse;
import kr.pe.afterschool.domain.country.service.CountryQueryService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryQueryService countryQueryService;

    @GetMapping
    public ResponseData<List<CountryResponse>> getCountries() {
        List<CountryResponse> response = countryQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "모든 행정구역 조회 성공",
                response
        );
    }
}

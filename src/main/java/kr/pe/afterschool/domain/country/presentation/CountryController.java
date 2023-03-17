package kr.pe.afterschool.domain.country.presentation;

import kr.pe.afterschool.domain.country.presentation.dto.request.CountryCreateRequest;
import kr.pe.afterschool.domain.country.presentation.dto.request.CountryEditRequest;
import kr.pe.afterschool.domain.country.presentation.dto.response.CountryResponse;
import kr.pe.afterschool.domain.country.service.CountryCreateService;
import kr.pe.afterschool.domain.country.service.CountryEditService;
import kr.pe.afterschool.domain.country.service.CountryQueryService;
import kr.pe.afterschool.domain.country.service.CountryRemoveService;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryQueryService countryQueryService;
    private final CountryCreateService countryCreateService;
    private final CountryEditService countryEditService;
    private final CountryRemoveService countryRemoveService;

    @GetMapping
    public ResponseData<List<CountryResponse>> getCountries() {
        List<CountryResponse> response = countryQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "모든 행정구역 조회 성공",
                response
        );
    }

    @PostMapping
    public Response createCountry(@RequestBody @Valid CountryCreateRequest request) {
        countryCreateService.execute(request);
        return new Response(
                HttpStatus.OK,
                "행정구역 생성 성공"
        );
    }

    @PutMapping("/{countryId}")
    public Response editCountry(
            @PathVariable Long countryId,
            @RequestBody CountryEditRequest request
    ) {
        countryEditService.execute(countryId, request);
        return new Response(
                HttpStatus.OK,
                "행정구역 수정 성공"
        );
    }

    @DeleteMapping("/{countryId}")
    public Response deleteCountry(@PathVariable Long countryId) {
        countryRemoveService.execute(countryId);
        return new Response(
                HttpStatus.OK,
                "행정 구역 삭제 성공"
        );
    }
}

package kr.pe.afterschool.domain.city.presentation;

import kr.pe.afterschool.domain.city.presentation.dto.request.CityCreateRequest;
import kr.pe.afterschool.domain.city.presentation.dto.request.CityEditRequest;
import kr.pe.afterschool.domain.city.presentation.dto.response.CityResponse;
import kr.pe.afterschool.domain.city.service.*;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CitiesQueryService citiesQueryService;
    private final CitiesByCountryQueryService citiesByCountryQueryService;
    private final CityCreateService cityCreateService;
    private final CityEditService cityEditService;
    private final CityRemoveService cityRemoveService;

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

    @PostMapping
    public Response createCity(
            @RequestBody @Valid CityCreateRequest request
    ) {
        cityCreateService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "도시 생성 성공"
        );
    }

    @PatchMapping("/{cityId}")
    public Response editCity(
            @PathVariable Long cityId,
            @RequestBody CityEditRequest request
    ) {
        cityEditService.execute(cityId, request);
        return new Response(
                HttpStatus.OK,
                "도시 수정 성공"
        );
    }

    @DeleteMapping("/{cityId}")
    public Response remove(
            @PathVariable Long cityId
    ) {
        cityRemoveService.execute(cityId);
        return new Response(
                HttpStatus.OK,
                "도시 삭제 성공"
        );
    }
}

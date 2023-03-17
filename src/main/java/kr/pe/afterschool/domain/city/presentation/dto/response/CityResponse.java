package kr.pe.afterschool.domain.city.presentation.dto.response;

import kr.pe.afterschool.domain.city.entity.City;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CityResponse {

    private Long cityId;
    private String city;
    private String country;

    public CityResponse(City city) {
        this.cityId = city.getId();
        this.city = city.getName();
        this.country = city.getCountry().getName();
    }
}

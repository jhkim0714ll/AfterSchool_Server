package kr.pe.afterschool.domain.country.presentation.dto.response;

import kr.pe.afterschool.domain.country.entity.Country;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CountryResponse {

    private Long countryId;
    private String name;

    public CountryResponse(Country country) {
        this.countryId = country.getId();
        this.name = country.getName();
    }
}

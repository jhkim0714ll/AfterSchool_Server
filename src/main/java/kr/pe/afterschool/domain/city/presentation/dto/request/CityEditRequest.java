package kr.pe.afterschool.domain.city.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CityEditRequest {

    private String name;
    private Long countryId;
}

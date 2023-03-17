package kr.pe.afterschool.domain.city.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CityCreateRequest {

    @NotEmpty(message = "name must not empty")
    private String name;
    @NotNull(message = "countryId must not null")
    private Long countryId;
}

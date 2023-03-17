package kr.pe.afterschool.domain.country.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CountryCreateRequest {

    @NotEmpty(message = "name must not empty")
    private String name;
}

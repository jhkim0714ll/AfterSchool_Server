package kr.pe.afterschool.domain.school.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchoolCreateRequest {

    @NotEmpty(message = "name must not empty")
    private String name;
    @NotEmpty(message = "address must not empty")
    private String address;
    @NotEmpty(message = "home page must not empty")
    private String homePage;
    @NotEmpty(message = "phone must not empty")
    private String phone;
}

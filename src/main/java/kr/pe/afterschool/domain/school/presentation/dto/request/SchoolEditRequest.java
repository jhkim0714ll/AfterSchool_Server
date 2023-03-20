package kr.pe.afterschool.domain.school.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchoolEditRequest {

    private String name;
    private String address;
    private String homePage;
    private String phone;
}

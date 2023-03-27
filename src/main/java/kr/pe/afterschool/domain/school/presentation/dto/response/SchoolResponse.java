package kr.pe.afterschool.domain.school.presentation.dto.response;

import kr.pe.afterschool.domain.school.entity.School;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchoolResponse {

    private Long schoolId;
    private String name;
    private String address;
    private String homePage;
    private String phone;

    public SchoolResponse(School school) {
        this.schoolId = school.getId();
        this.name = school.getName();
        this.address = school.getAddress();
        this.homePage = school.getHomePage();
        this.phone = school.getPhone();
    }
}

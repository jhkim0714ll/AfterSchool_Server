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
    private String city;
    private String country;

    public SchoolResponse(School school) {
        this.schoolId = school.getId();
        this.name = school.getName();
        this.city = school.getCity().getName();
        this.country = school.getCountry().getName();
    }
}

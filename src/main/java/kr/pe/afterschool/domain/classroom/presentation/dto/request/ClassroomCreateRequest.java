package kr.pe.afterschool.domain.classroom.presentation.dto.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomCreateRequest {

    @NotEmpty(message = "teacherName must not empty")
    private String teacherName;
    @NotEmpty(message = "name must not empty")
    private String name;
    @NotEmpty(message = "week must not empty")
    private String week;
    private String startDate;
    private String endDate;
    private int peopleLimit;
}

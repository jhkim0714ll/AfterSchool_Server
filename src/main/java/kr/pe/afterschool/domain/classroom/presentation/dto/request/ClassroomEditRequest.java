package kr.pe.afterschool.domain.classroom.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomEditRequest {
    private String teacherName;
    private String name;
    private String description;
    private String week;
    private String startDate;
    private String endDate;
    private int peopleLimit;
}

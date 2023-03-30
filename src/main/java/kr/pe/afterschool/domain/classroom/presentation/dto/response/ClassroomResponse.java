package kr.pe.afterschool.domain.classroom.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomResponse {

    private Long classroomId;
    private String teacherName;
    private String name;
    private SchoolResponse school;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private int peopleLimit;

    public ClassroomResponse(Classroom classroom) {
        this.classroomId = classroom.getId();
        this.teacherName = classroom.getTeacherName();
        this.name = classroom.getName();
        this.school = new SchoolResponse(classroom.getSchool());
        this.startDate = classroom.getStartDate();
        this.endDate = classroom.getEndDate();
        this.peopleLimit = classroom.getPeopleLimit();
    }
}

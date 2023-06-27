package kr.pe.afterschool.domain.attendance.presentation.dto.response;

import kr.pe.afterschool.domain.attendance.entity.Attendance;
import kr.pe.afterschool.domain.attendance.enums.AttendanceType;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.Getter;

@Getter
public class AttendanceResponse {

    private final Long id;
    private final ClassroomResponse classroom;
    private final UserResponse user;
    private final AttendanceType type;

    public AttendanceResponse(Attendance attendance) {
        this.id = attendance.getId();
        this.classroom = new ClassroomResponse(attendance.getClassroom());
        this.user = new UserResponse(attendance.getUser());
        this.type = attendance.getType();
    }
}

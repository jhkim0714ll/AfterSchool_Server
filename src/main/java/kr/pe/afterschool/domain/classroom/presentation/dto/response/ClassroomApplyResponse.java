package kr.pe.afterschool.domain.classroom.presentation.dto.response;

import kr.pe.afterschool.domain.classroom.entity.ClassroomApply;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomApplyResponse {

    private Long classroomUserId;
    private UserResponse student;
    private ClassroomResponse classroom;

    public ClassroomApplyResponse(ClassroomApply classroomApply) {
        this.classroomUserId = classroomApply.getId();
        this.student = new UserResponse(classroomApply.getStudent());
        this.classroom = new ClassroomResponse(classroomApply.getClassroom());
    }
}

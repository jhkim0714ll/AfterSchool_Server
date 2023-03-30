package kr.pe.afterschool.domain.classroom.presentation.dto.response;

import kr.pe.afterschool.domain.classroom.entity.ClassroomUser;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomUserResponse {

    private Long classroomUserId;
    private UserResponse student;
    private ClassroomResponse classroomResponse;

    public ClassroomUserResponse(ClassroomUser classroomUser) {
        this.classroomUserId = classroomUser.getId();
        this.student = new UserResponse(classroomUser.getStudent());
        this.classroomResponse = new ClassroomResponse(classroomUser.getClassroom());
    }
}

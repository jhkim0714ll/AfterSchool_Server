package kr.pe.afterschool.domain.apply.presentation.dto.response;

import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplyResponse {

    private Long applyId;
    private UserResponse student;
    private ClassroomResponse classroom;

    public ApplyResponse(Apply apply) {
        this.applyId = apply.getId();
        this.student = new UserResponse(apply.getStudent());
        this.classroom = new ClassroomResponse(apply.getClassroom());
    }
}

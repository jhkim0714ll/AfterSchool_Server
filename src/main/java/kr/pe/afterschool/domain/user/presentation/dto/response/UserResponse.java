package kr.pe.afterschool.domain.user.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.global.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UserResponse {

    private String email;
    private String name;
    private String phone;
    private int grade;
    private int room;
    private int number;
    private UserRole role;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
    private Long schoolId;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.grade = user.getGrade();
        this.room = user.getRoom();
        this.number = user.getNumber();
        this.role = user.getRole();
        this.joinDate = user.getJoinDate();
        this.schoolId = user.getSchool() == null ? null : user.getSchool().getId();
    }
}

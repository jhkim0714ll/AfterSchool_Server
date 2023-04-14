package kr.pe.afterschool.domain.auth.presentation.dto.request;

import kr.pe.afterschool.global.enums.UserRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterRequest {

    @NotBlank(message = "email must not be black")
    private String email;
    @NotBlank(message = "pw must not be black")
    private String pw;
    @NotBlank(message = "name must not be black")
    private String name;
    @NotBlank(message = "phone must not be black")
    private String phone;
    private int grade;
    private int room;
    private int number;
    private UserRole role;
    private String profileImageUrl;
}

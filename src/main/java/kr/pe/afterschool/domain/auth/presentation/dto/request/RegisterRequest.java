package kr.pe.afterschool.domain.auth.presentation.dto.request;

import kr.pe.afterschool.global.enums.UserRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterRequest {

    @NotNull(message = "email must not be null")
    private String email;
    @NotNull(message = "pw must not be null")
    private String pw;
    @NotNull(message = "name must not be null")
    private String name;
    @NotNull(message = "phone must not be null")
    private String phone;
    private int grade;
    private int room;
    private int number;
    private UserRole role;
    private String profileImageUrl;
}

package kr.pe.afterschool.domain.auth.presentation.dto.response;

import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private UserResponse user;
    private String accessToken;
    private String refreshToken;
}

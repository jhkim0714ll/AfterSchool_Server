package kr.pe.afterschool.domain.auth.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OauthLoginRequest {

    @NotBlank(message = "code must not be blank")
    private String code;
}

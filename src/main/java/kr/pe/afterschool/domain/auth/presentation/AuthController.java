package kr.pe.afterschool.domain.auth.presentation;

import kr.pe.afterschool.domain.auth.presentation.dto.request.LoginRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.response.LoginResponse;
import kr.pe.afterschool.domain.auth.service.LoginService;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    @PostMapping
    public ResponseData<LoginResponse> login(LoginRequest request) {
        LoginResponse response = loginService.execute(request);
        return new ResponseData<>(
                HttpStatus.CREATED,
                "로그인 성공",
                response
        );
    }
}

package kr.pe.afterschool.domain.auth.presentation;

import kr.pe.afterschool.domain.auth.presentation.dto.request.LoginRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.request.RegisterRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.response.LoginResponse;
import kr.pe.afterschool.domain.auth.service.LoginService;
import kr.pe.afterschool.domain.auth.service.RegisterService;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    private RegisterService registerService;

    @PostMapping
    public ResponseData<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        LoginResponse response = loginService.execute(request);
        return new ResponseData<>(
                HttpStatus.CREATED,
                "로그인 성공",
                response
        );
    }

    @PostMapping("/register")
    public Response register(@RequestBody @Valid RegisterRequest request) {
        registerService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "회원가입 성공"
        );
    }
}

package kr.pe.afterschool.domain.auth.presentation;

import kr.pe.afterschool.domain.auth.presentation.dto.request.OauthLoginRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.request.LoginRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.request.OauthRegisterRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.request.RegisterRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.response.LoginResponse;
import kr.pe.afterschool.domain.auth.service.*;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    private final RegisterService registerService;
    private final KaKaoLoginService kaKaoLoginService;
    private final KaKaoRegisterService kaKaoRegisterService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseData<LoginResponse> login(
            @RequestBody @Valid LoginRequest request
    ) {
        LoginResponse response = loginService.execute(request);
        return new ResponseData<>(
                HttpStatus.CREATED,
                "로그인 성공",
                response
        );
    }

    @PostMapping("/register")
    public Response register(
            @RequestBody @Valid RegisterRequest request
    ) {
        registerService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "회원가입 성공"
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/kakao/login")
    public ResponseData<LoginResponse> kakaoLogin(
            @RequestBody @Valid OauthLoginRequest request
    ) {
        LoginResponse response = kaKaoLoginService.execute(request);
        return new ResponseData<>(
                HttpStatus.CREATED,
                "카카오 Oauth 로그인 성공",
                response
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/oauth/register")
    public Response oauthRegister(
            @RequestBody @Valid OauthRegisterRequest request
    ) {
        kaKaoRegisterService.execute(request);
        return new Response(
                HttpStatus.OK,
                "카카오 계정으로 회원 가입 성공"
        );
    }
}

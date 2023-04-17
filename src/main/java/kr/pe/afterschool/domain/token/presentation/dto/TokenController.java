package kr.pe.afterschool.domain.token.presentation.dto;

import kr.pe.afterschool.domain.token.presentation.dto.request.RefreshTokenRequest;
import kr.pe.afterschool.domain.token.presentation.dto.response.RefreshTokenResponse;
import kr.pe.afterschool.domain.token.presentation.service.RefreshTokenService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {

    private final RefreshTokenService refreshTokenService;

    @PostMapping("/refresh")
    public ResponseData<RefreshTokenResponse> getTokenByRefreshToken(
            @RequestBody RefreshTokenRequest request
    ) {
        RefreshTokenResponse response = refreshTokenService.execute(request);
        return new ResponseData<>(
                HttpStatus.CREATED,
                "토큰 재발급 성공",
                response
        );
    }
}

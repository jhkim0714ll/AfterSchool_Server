package kr.pe.afterschool.domain.auth.service;

import kr.pe.afterschool.domain.auth.presentation.dto.request.KaKaoLoginRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.response.LoginResponse;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.exception.UserNotFoundException;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import kr.pe.afterschool.global.config.properties.JwtProperties;
import kr.pe.afterschool.global.config.properties.KaKaoProperties;
import kr.pe.afterschool.global.security.jwt.JwtTokenProvider;
import kr.pe.afterschool.thirdparth.feign.client.KaKaoAuth;
import kr.pe.afterschool.thirdparth.feign.client.KaKaoUserInfo;
import kr.pe.afterschool.thirdparth.feign.dto.response.KaKaoTokenResponse;
import kr.pe.afterschool.thirdparth.feign.dto.response.KaKaoUserInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KaKaoLoginService {

    private final UserRepository userRepository;
    private final KaKaoAuth kaKaoAuth;
    private final KaKaoUserInfo kakaoUserInfo;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final KaKaoProperties kaKaoProperties;

    @Transactional
    public LoginResponse execute(KaKaoLoginRequest request) {
        KaKaoTokenResponse tokenResponse = kaKaoAuth.getTokenByCode(
                kaKaoProperties.getGrantType(),
                request.getCode(),
                kaKaoProperties.getClientId(),
                kaKaoProperties.getClientSecret(),
                kaKaoProperties.getRedirectUrl()
        );

        KaKaoUserInfoResponse userInfo = kakaoUserInfo.getUserInfo(
                "Bearer " + tokenResponse.getAccess_token());

        User user = userRepository.findById(userInfo.getKakao_account().getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        String token = jwtTokenProvider.generateAccessToken(user.getEmail());
        return LoginResponse.builder()
                .user(new UserResponse(user))
                .token(token)
                .build();
    }
}

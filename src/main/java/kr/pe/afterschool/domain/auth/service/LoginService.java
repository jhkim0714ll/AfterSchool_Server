package kr.pe.afterschool.domain.auth.service;

import kr.pe.afterschool.domain.auth.exception.DoNotJoinException;
import kr.pe.afterschool.domain.auth.exception.PasswordNotMatchException;
import kr.pe.afterschool.domain.auth.exception.WrongJoinMethodException;
import kr.pe.afterschool.domain.auth.presentation.dto.request.LoginRequest;
import kr.pe.afterschool.domain.auth.presentation.dto.response.LoginResponse;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.entity.repository.UserRepository;
import kr.pe.afterschool.domain.user.exception.UserNotFoundException;
import kr.pe.afterschool.domain.user.presentation.dto.response.UserResponse;
import kr.pe.afterschool.global.enums.JoinMethod;
import kr.pe.afterschool.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public LoginResponse execute(LoginRequest loginRequest) {
        if (!userRepository.existsById(loginRequest.getEmail())) {
            throw DoNotJoinException.EXCEPTION;
        }
        User user = userRepository.findById(loginRequest.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if (!passwordEncoder.matches(loginRequest.getPw(), user.getPw())) {
            if (user.getJoinMethod().equals(JoinMethod.KAKAO)) {
                throw WrongJoinMethodException.EXCEPTION;
            }
            throw PasswordNotMatchException.EXCEPTION;
        }
        String token = jwtTokenProvider.generateAccessToken(user.getEmail());
        return LoginResponse.builder()
                .user(new UserResponse(user))
                .token(token)
                .build();
    }
}

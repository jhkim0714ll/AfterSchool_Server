package kr.pe.afterschool.domain.token.service;

import kr.pe.afterschool.domain.token.exception.TokenBadRequestException;
import kr.pe.afterschool.domain.token.presentation.dto.request.RefreshTokenRequest;
import kr.pe.afterschool.domain.token.presentation.dto.response.RefreshTokenResponse;
import kr.pe.afterschool.global.enums.JWT;
import kr.pe.afterschool.global.security.jwt.JwtTokenParser;
import kr.pe.afterschool.global.security.jwt.JwtTokenProvider;
import kr.pe.afterschool.global.security.principle.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtTokenParser jwtTokenParser;
    private final AuthDetailsService authDetailsService;

    public RefreshTokenResponse execute(RefreshTokenRequest request) {
        if (request.getToken() == null || request.getToken().isBlank()) {
            throw TokenBadRequestException.EXCEPTION;
        }

        UserDetails userDetails = authDetailsService
                .loadUserByUsername(jwtTokenParser.getTokenBody(request.getToken(), JWT.REFRESH).getSubject());
        String token = jwtTokenProvider.generateToken(userDetails.getUsername(), JWT.ACCESS);
        return new RefreshTokenResponse(token);
    }
}

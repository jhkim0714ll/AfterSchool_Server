package kr.pe.afterschool.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.pe.afterschool.global.config.properties.JwtProperties;
import kr.pe.afterschool.global.enums.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtTokenParser jwtTokenParser;
    private final JwtProperties jwtProperties;

    public String generateToken(String email, JWT jwt) {
        return generateToken(email, jwtProperties.getAccessExp(), jwt);
    }

    private String generateToken(String email, Long exp, JWT jwt) {
        String key = jwtTokenParser.getKeyByJwt(jwt);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 10000))
                .compact();
    }
}

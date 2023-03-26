package kr.pe.afterschool.global.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.afterschool.global.lib.ErrorToJson;
import kr.pe.afterschool.global.security.jwt.JwtTokenParser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenParser jwtTokenParser;
    private final ErrorToJson errorToJson;

    @Override
    public void configure(HttpSecurity builder) {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenParser);
        ExceptionFilter exceptionFilter = new ExceptionFilter(errorToJson);
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(exceptionFilter, JwtTokenFilter.class);
    }
}

package kr.pe.afterschool.global.security;

import kr.pe.afterschool.global.filter.FilterConfig;
import kr.pe.afterschool.global.filter.JwtTokenFilter;
import kr.pe.afterschool.global.lib.ErrorToJson;
import kr.pe.afterschool.global.security.handler.CustomAccessDeniedHandler;
import kr.pe.afterschool.global.security.handler.CustomAuthenticationEntryPoint;
import kr.pe.afterschool.global.security.jwt.JwtTokenParser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtTokenParser jwtTokenParser;
    private final ErrorToJson errorToJson;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET).hasAnyRole("TEACHER", "ADMIN", "STUDENT")
                .antMatchers("/school/**", "/classroom/**", "apply/decision/**").hasAnyRole("TEACHER", "ADMIN")
                .antMatchers("/auth/**").permitAll();
        http
                .apply(new FilterConfig(jwtTokenParser, errorToJson));
        http
                .addFilterBefore(new JwtTokenFilter(jwtTokenParser), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler);
        return http.build();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

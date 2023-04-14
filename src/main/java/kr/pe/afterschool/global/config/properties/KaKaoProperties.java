package kr.pe.afterschool.global.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("app.thirdparth.kakao")
public class KaKaoProperties {

    private String adminKey;
    private String grantType;
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
}

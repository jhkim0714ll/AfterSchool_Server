package kr.pe.afterschool.thirdparth.feign;

import feign.codec.ErrorDecoder;
import kr.pe.afterschool.thirdparth.feign.error.FeignClientErrorDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "kr.pe.afterschool.thirdparth.feign")
public class FeignConfiguration {

    @Bean
    @ConditionalOnMissingBean(value = ErrorDecoder.class)
    public FeignClientErrorDecoder commonFeignErrorDecoder() {
        return new FeignClientErrorDecoder();
    }
}

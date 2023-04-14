package kr.pe.afterschool.thirdparth.feign.client;

import kr.pe.afterschool.thirdparth.feign.dto.response.KaKaoTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "KaKaoAuth", url = "https://kauth.kakao.com")
public interface KaKaoAuth {

    @PostMapping(value = "/oauth/token", produces = "application/json")
    KaKaoTokenResponse getTokenByCode(
            @RequestParam(name = "grant_type") String grantType,
            @RequestParam(name = "code") String code,
            @RequestParam(name = "client_id") String clientId,
            @RequestParam(name = "client_secret") String clientSecret,
            @RequestParam(name = "redirect_uri") String redirectUri
    );
}

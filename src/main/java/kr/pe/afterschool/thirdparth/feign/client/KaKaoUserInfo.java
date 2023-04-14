package kr.pe.afterschool.thirdparth.feign.client;

import kr.pe.afterschool.thirdparth.feign.dto.response.KaKaoUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "KaKaoUserInfo", url = "https://kapi.kakao.com")
public interface KaKaoUserInfo {

    @GetMapping(value = "/v2/user/me", produces = "application/json")
    KaKaoUserInfoResponse getUserInfo(@RequestHeader("Authorization") String token);
}

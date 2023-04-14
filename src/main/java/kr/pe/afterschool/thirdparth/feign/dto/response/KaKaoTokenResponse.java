package kr.pe.afterschool.thirdparth.feign.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KaKaoTokenResponse {

    private String access_token;
}

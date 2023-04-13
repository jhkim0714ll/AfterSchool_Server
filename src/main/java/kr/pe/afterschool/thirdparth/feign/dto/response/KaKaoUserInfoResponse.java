package kr.pe.afterschool.thirdparth.feign.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class KaKaoUserInfoResponse {

    private Long id;

    private KaKaoAccount kakao_account;

    @Getter
    @Setter
    public static final class KaKaoAccount {

        private String email;
        private Profile profile;

        @Getter
        @Setter
        public static final class Profile {
            private String nickname;
            private String profile_image_url;
        }
    }
}

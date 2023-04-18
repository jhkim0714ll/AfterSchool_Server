package kr.pe.afterschool.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEditSchoolRequest {

    private Long schoolId;
}

package kr.pe.afterschool.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserEditRequest {

    private String name;
    private String phone;
    private int grade;
    private int room;
    private int number;
    private String profileImageUrl;
}

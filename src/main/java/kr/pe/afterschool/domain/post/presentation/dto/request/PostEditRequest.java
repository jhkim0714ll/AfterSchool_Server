package kr.pe.afterschool.domain.post.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEditRequest {

    private String title;
    private String content;
}

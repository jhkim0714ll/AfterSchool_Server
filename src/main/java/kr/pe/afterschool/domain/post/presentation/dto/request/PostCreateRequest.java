package kr.pe.afterschool.domain.post.presentation.dto.request;

import kr.pe.afterschool.global.enums.PostType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostCreateRequest {

    @NotEmpty(message = "title must not empty")
    private String title;
    @NotEmpty(message = "content must not empty")
    private String content;
    @NotNull(message = "type must not null")
    private PostType type;
}

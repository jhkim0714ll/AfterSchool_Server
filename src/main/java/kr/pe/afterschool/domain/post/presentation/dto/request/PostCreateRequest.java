package kr.pe.afterschool.domain.post.presentation.dto.request;

import kr.pe.afterschool.global.enums.PostType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostCreateRequest {

    @NotBlank(message = "title must not black")
    private String title;
    @NotBlank(message = "content must not black")
    private String content;
    @NotNull(message = "type must not null")
    private PostType type;
}

package kr.pe.afterschool.domain.post.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import kr.pe.afterschool.domain.post.entity.Post;
import kr.pe.afterschool.global.enums.PostType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponse {

    private Long postId;
    private String title;
    private String content;
    private int views;
    private PostType type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    public PostResponse(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.views = post.getViews();
        this.type = post.getType();
        this.createdDate = post.getCreatedDate();
    }
}

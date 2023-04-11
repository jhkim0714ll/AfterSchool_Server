package kr.pe.afterschool.domain.post.entity;

import kr.pe.afterschool.global.enums.PostType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "classroom")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private int views;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostType type;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdDate;

    @Builder
    public Post(String title, String content, PostType type) {
        this.title = title;
        this.content = content;
        this.views = 0;
        this.type = type;
        this.createdDate = LocalDate.now();
    }
}

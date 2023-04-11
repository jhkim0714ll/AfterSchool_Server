package kr.pe.afterschool.domain.post.entity;

import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.user.entity.User;
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
@Table(name = "post")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_school_id")
    private School school;

    public void editPost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public Post(String title, String content, PostType type, User user, School school) {
        this.title = title;
        this.content = content;
        this.views = 0;
        this.type = type;
        this.createdDate = LocalDate.now();
        this.user = user;
        this.school = school;
    }
}

package kr.pe.afterschool.domain.survey.entity;

import kr.pe.afterschool.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "survey")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_student_id")
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_classroom_id")
    private Classroom classroom;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdDate;

    public void editSurvey(String content) {
        this.content = content;
    }

    @Builder
    public Survey(String content, User student, Classroom classroom) {
        this.content = content;
        this.student = student;
        this.classroom = classroom;
        this.createdDate = LocalDate.now();
    }
}

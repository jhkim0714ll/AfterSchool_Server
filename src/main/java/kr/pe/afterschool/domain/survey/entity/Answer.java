package kr.pe.afterschool.domain.survey.entity;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
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
@Table(name = "answer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long id;

    @Column(nullable = false)
    private String answer;

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
        this.answer = content;
    }

    @Builder
    public Answer(String answer, User student, Classroom classroom) {
        this.answer = answer;
        this.student = student;
        this.classroom = classroom;
        this.createdDate = LocalDate.now();
    }
}

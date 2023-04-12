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
    @Column(name = "answer_id")
    private Long id;

    @Column(nullable = false)
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_student_id")
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_question_id")
    private Question question;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdDate;

    public void editSurvey(String content) {
        this.answer = content;
    }

    @Builder
    public Answer(String answer, User student, Question question) {
        this.answer = answer;
        this.student = student;
        this.question = question;
        this.createdDate = LocalDate.now();
    }
}

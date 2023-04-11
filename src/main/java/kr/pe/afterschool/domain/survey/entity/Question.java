package kr.pe.afterschool.domain.survey.entity;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.school.entity.School;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(nullable = false)
    private String questions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_school_id")
    private School school;

    @Builder
    public Question(String questions, School school) {
        this.questions = questions;
        this.school = school;
    }
}

package kr.pe.afterschool.domain.classroom.entity;

import kr.pe.afterschool.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "classroom_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_classroom_id")
    private Classroom classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_student_id")
    private User student;

    @Builder
    public ClassroomUser(Classroom classroom, User student) {
        this.classroom = classroom;
        this.student = student;
    }
}

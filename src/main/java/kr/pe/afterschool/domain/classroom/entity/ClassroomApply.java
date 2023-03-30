package kr.pe.afterschool.domain.classroom.entity;

import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.global.enums.ClassroomApplyStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "classroom_apply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_classroom_id")
    private Classroom classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_student_id")
    private User student;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClassroomApplyStatus status;

    public void editStatus(ClassroomApplyStatus status) {
        this.status = status;
    }

    @Builder
    public ClassroomApply(Classroom classroom, User student) {
        this.classroom = classroom;
        this.student = student;
        this.status = ClassroomApplyStatus.PENDING;
    }
}

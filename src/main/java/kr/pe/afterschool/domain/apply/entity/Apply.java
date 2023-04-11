package kr.pe.afterschool.domain.apply.entity;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.global.enums.ApplyStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "apply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_classroom_id")
    private Classroom classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_student_id")
    private User student;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplyStatus status;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdDate;

    public void editStatus(ApplyStatus status) {
        this.status = status;
    }

    @Builder
    public Apply(Classroom classroom, User student) {
        this.classroom = classroom;
        this.student = student;
        this.status = ApplyStatus.PENDING;
        this.createdDate = LocalDate.now();
    }
}

package kr.pe.afterschool.domain.attendance.entity;

import kr.pe.afterschool.domain.attendance.enums.AttendanceType;
import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.user.entity.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "attendance")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttendanceType type;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdDate;

    @Builder
    public Attendance(Classroom classroom, User user, AttendanceType type) {
        this.classroom = classroom;
        this.user = user;
        this.type = type;
        this.createdDate = LocalDate.now();
    }
}

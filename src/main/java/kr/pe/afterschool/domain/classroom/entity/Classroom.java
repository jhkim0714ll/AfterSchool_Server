package kr.pe.afterschool.domain.classroom.entity;

import kr.pe.afterschool.domain.school.entity.School;
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
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private Long id;

    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdAt;

    @Builder
    public Classroom(String teacherName, String name, School school) {
        this.teacherName = teacherName;
        this.name = name;
        this.school = school;
        this.createdAt = LocalDate.now();
    }
}

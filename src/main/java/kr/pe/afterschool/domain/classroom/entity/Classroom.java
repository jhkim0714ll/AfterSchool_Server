package kr.pe.afterschool.domain.classroom.entity;

import kr.pe.afterschool.domain.school.entity.School;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.DayOfWeek;
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

    @Column(nullable = false)
    private DayOfWeek week;

    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

    private LocalDate startDate;
    private LocalDate endDate;
    private int peopleLimit;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdAt;

    public void editClassroomData(String teacherName, String name, DayOfWeek week, LocalDate startDate, LocalDate endDate, int peopleLimit) {
        this.teacherName = teacherName;
        this.name = name;
        this.week = week;
        this.startDate = startDate;
        this.endDate = endDate;
        this.peopleLimit = peopleLimit;
    }

    @Builder
    public Classroom(String teacherName, String name, DayOfWeek week, School school, LocalDate startDate, LocalDate endDate, int peopleLimit) {
        this.teacherName = teacherName;
        this.name = name;
        this.week = week;
        this.school = school;
        this.startDate = startDate;
        this.endDate = endDate;
        this.peopleLimit = peopleLimit;
        this.createdAt = LocalDate.now();
    }
}

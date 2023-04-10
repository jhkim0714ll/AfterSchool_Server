package kr.pe.afterschool.domain.school.entity;

import kr.pe.afterschool.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "school")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String educationOffice;

    @Column(nullable = false)
    private String homePage;

    @Column(nullable = false)
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_teacher_id")
    private User teacher;

    public void editSchoolData(String name, String address, String educationOffice, String homePage, String phone) {
        this.name = name;
        this.address = address;
        this.educationOffice = educationOffice;
        this.homePage = homePage;
        this.phone = phone;
    }

    @Builder
    public School(String name, String address, String educationOffice,String homePage, String phone, User teacher) {
        this.name = name;
        this.address = address;
        this.educationOffice = educationOffice;
        this.homePage = homePage;
        this.phone = phone;
        this.teacher = teacher;
    }
}

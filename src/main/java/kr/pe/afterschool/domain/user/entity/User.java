package kr.pe.afterschool.domain.user.entity;

import kr.pe.afterschool.global.enums.UserRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    private String email;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    private int grade;

    private int room;

    private int number;

    @Column(nullable = false)
    private UserRole role;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate joinDate;
}

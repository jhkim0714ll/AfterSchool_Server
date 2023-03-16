package kr.pe.afterschool.domain.user.entity;

import kr.pe.afterschool.global.enums.UserRole;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    private String email;

    private String pw;

    private String name;

    private String phone;

    private int grade;

    private int room;

    private int number;

    private UserRole role;

    private LocalDate joinDate;
}

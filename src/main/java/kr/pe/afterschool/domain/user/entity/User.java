package kr.pe.afterschool.domain.user.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}

package com.example.demo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AppUser {
    @Id @GeneratedValue
    private long id;
    @Column(unique=true)
    private String email;
    private LocalDate dob;
    @Transient
    private int age;
    private String message;
    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}

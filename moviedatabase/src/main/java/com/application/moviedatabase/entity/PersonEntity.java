package com.application.moviedatabase.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "person")
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    private String country;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String biography;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private String role;

}

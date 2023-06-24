package com.application.moviedatabase.entity;

import com.application.moviedatabase.constant.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.util.List;

@Entity(name = "person")
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Length(min = 3)
    private String name;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private String country;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String biography;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "director")
    private List<MovieEntity> directedMovies;

    @ManyToMany(mappedBy = "actors")
    private List<MovieEntity> actedInMovies;

}

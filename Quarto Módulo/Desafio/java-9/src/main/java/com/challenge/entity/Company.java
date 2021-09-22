package com.challenge.entity;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Company")
@EntityListeners({})
public class Company {

    @OneToMany
    private List<Candidate> candidates;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size( max = 100)
    private String name;

    @NotNull
    @Size( max = 50)
    private String slug;

    @NotNull
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Timestamp createdAt;
}

// https://www.baeldung.com/jpa-entities -> ids && temporal && table
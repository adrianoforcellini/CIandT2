package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners({})
@Table(name="User")
public class User {

    @OneToMany
    private List<Submission> submission;

    @OneToMany
    private List<Candidate> candidates;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size( max = 100)
    private String fullName;

    @NotNull
    @Size( max = 100)
    @Email
    private String email;

    @NotNull
    @Size( max = 50)
    private String nickname;

    @NotNull
    @Size( max =255)
    private String password;

    @NotNull
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Timestamp createdAt;
}

// UserTest>TableWithIdTest.hasIdWithAnnotationGeneratedValueWithStrategyIdentity:33-
// https://stackoverflow.com/questions/20603638/what-is-the-use-of-annotations-id-and-generatedvaluestrategy-generationtype

// UserTest.hasColumnFullNameSize:55
// UserTest.hasColumnNicknameSize:110
// UserTest.hasColumnPasswordSize:133
// ->  https://www.baeldung.com/jpa-size-length-column-differences
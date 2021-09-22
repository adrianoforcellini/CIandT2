package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners({})
@Table(name="Submission")
public class Submission {

    @EmbeddedId
    private SubmissionHelper submissionHelper;

    @NotNull
    private float score;

    @NotNull
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Timestamp createdAt;
}

// https://stackoverflow.com/questions/11905956/jpa-foreign-key-annotation
// foreign-key annotation

// entity-embedded-and-composite-primary-keys
// https://www.baeldung.com/spring-jpa-embedded-method-parameters
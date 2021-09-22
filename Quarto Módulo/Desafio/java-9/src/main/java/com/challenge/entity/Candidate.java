package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@Table(name="Candidate")
@EntityListeners({})

public class Candidate {

    @EmbeddedId
    private CandidateHelper candidateHelper;

    @NotNull
    private String status;

    @NotNull
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Timestamp createdAt;

}


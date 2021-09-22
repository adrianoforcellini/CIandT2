package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



@Embeddable
public class CandidateHelper implements Serializable {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
    private Company company_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
    private Acceleration acceleration_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
    private User user_id;

}

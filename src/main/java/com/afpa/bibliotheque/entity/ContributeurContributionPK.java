package com.afpa.bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ContributeurContributionPK implements Serializable {

    @Column(name = "contributeur_id", insertable = false, updatable = false)
    private Long contributeurId;

    @Column(name = "contribution_id", insertable = false, updatable = false)
    private Long contributionId;


}

package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contributeur_contribution")
public class ContributeurContribution {
    @EmbeddedId
    private ContributeurContributionPK id;

    @ManyToOne
    @JoinColumn(name = "contributeur_id")
    @MapsId("contributeurId")
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name = "contribution_id")
    @MapsId("contributionId")
    private Contribution contribution;


}

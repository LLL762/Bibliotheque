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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContributeurContributionPK that = (ContributeurContributionPK) o;

        if (!contributeurId.equals(that.contributeurId)) return false;
        return contributionId.equals(that.contributionId);
    }

    @Override
    public int hashCode() {
        int result = contributeurId.hashCode();
        result = 31 * result + contributionId.hashCode();
        return result;
    }
}

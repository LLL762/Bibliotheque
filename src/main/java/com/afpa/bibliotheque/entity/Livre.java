package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 18/07/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Livre {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The Isbn.
     */
    @Column(unique = true, nullable = false)
    private Long isbn;
    /**
     * The Titre.
     */
    @Column(nullable = false)
    private String titre;
    /**
     * The Icon url.
     */
    private String iconUrl;
    /**
     * The Theme.
     */

//    @ToString.Exclude
//    private Theme theme;

    @ManyToMany
    @JoinTable(name = "livre_contributeur_contribution",
            joinColumns = @JoinColumn(name = "livre_id"),
            inverseJoinColumns = {@JoinColumn(name = "contributeur_id"),
                    @JoinColumn(name = "contribution_id")})
    @ToString.Exclude
    private List<ContributeurContribution> contributeurContributions = new ArrayList<>();
}

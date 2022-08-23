package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.AUTO;

/**
 * 18/07/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@Setter
@Entity
public class Theme {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    /**
     * The Nom.
     */
    @Column(nullable = false, unique = true)
    private String nom;
    /**
     * The Description.
     */
    @Basic(fetch = LAZY)
    @Column
    private String description;


}

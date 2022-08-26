package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

/**
 * The type Emprunt.
 */
@Entity
@Table
@Getter
@Setter
public class Emprunt {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Adherent.
     */
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_adherent" )
    private Utilisateur adherent;

    /**
     * The Date emprunt.
     */
    @Column( name = "date_emprunt", nullable = false )
    private LocalDate dateEmprunt;

    /**
     * The Date rendu precu.
     */
    @Column( name = "date_rendu_prevu" )
    private LocalDate dateRenduPrevu;

    /**
     * The Date rendu effectif.
     */
    @Column( name = "date_rendu_effectif" )
    private LocalDate dateRenduEffectif;

}

package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

/**
 * The type Emplacement.
 */
@Entity
@Table( name = "emplacement" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Emplacement
{
    /**
     * The Id.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    /**
     * The Bibliotheque.
     */
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_bibli" )
    private Bibliotheque bibliotheque;

    /**
     * The Theme.
     */
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_theme" )
    private Theme theme;

    /**
     * The Libelle.
     */
    @Column( name = "libelle" )
    private String libelle;
}

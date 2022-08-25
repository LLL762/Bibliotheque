package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

/**
 * The type Exemplaire.
 */
@Entity
@Table( name = "exemplaire" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Exemplaire
{
    /**
     * The Id.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    /**
     * The Emplacement.
     */
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_emplac" )
    private Emplacement emplacement;

    /**
     * The Livre.
     */
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_livre" )
    private Livre livre;

    /**
     * The Usure.
     */
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_usure" )
    private Usure usure;

    /*
    @OneToMany( fetch = LAZY )
    @JoinColumn( name = "id_emprunt" )
    private Emprunt emprunt;
    */

    /**
     * The Commentaire.
     */
    @ToString.Exclude
    @Column( name = "commentaire", length = 500 )
    private String commentaire;
}

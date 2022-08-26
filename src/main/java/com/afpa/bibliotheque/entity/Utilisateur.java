package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type Utilisateur.
 */

@Entity
@Table( name = "utilisateur" )
@Getter
@Setter
public
class Utilisateur
{
    /**
     * The Id.
     */
    @Id

    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    /**
     * The Nom.
     */
    @Column( name = "nom", length = 50, nullable = false )
    private String nom;

    /**
     * The Prenom.
     */
    @Column( name = "prenom", length = 50, nullable = false )
    private String prenom;

    /**
     * The Adresse.
     */
    @Column( name = "adresse", length = 500 )
    private String adresse;

    /**
     * The Telephone.
     */
    @Column( name = "telephone", length = 10 )
    private Integer telephone;

    /**
     * The Email.
     */
    @Column( name = "email", length = 50, nullable = false, unique = true )
    private String email;

    /**
     * The Password.
     */
    @Column( name = "pwd", length = 50, nullable = false )
    private String password;

    /**
     * The Date adhesion.
     */
    @Column( name = "date_adhesion" )
    private LocalDate dateAdhesion;

    /**
     * The Date fin adhesion.
     */
    @Column( name = "date_fin_adhesion" )
    private LocalDate dateFinAdhesion;
}

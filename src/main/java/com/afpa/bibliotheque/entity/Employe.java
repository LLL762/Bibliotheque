package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

/**
 * The type Employe.
 */
@Entity
@Table( name = "employe" )
@Getter
@Setter
public
class Employe
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
    @Column( name = "nom", length = 50 )
    private String nom;

    /**
     * The Prenom.
     */
    @Column( name = "prenom", length = 50 )
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
    @Column( name = "email", length = 50 )
    private String email;

    /**
     * The Password.
     */
    @Column( name = "pwd", length = 50 )
    private String password;

    /**
     * The Role.
     */
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_role" )
    private Role role;

    /**
     * The Bibliotheque.
     */
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_bibli" )
    private Bibliotheque bibliotheque;
}


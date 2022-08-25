package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table
@Getter
@Setter
public
class Employe
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "nom", length = 50 )
    private String nom;

    @Column( name = "prenom", length = 50 )
    private String prenom;

    @Column( name = "adresse", length = 500 )
    private String adresse;

    @Column( name = "telephone", length = 10 )
    private Integer telephone;

    @Column( name = "email", length = 50 )
    private String email;

    @Column( name = "pwd", length = 50 )
    private String password;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_role" )
    private Role role;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_bibli" )
    private Bibliotheque bibliotheque;
}


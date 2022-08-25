package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public
class Role
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "libelle", length = 50 )
    private String libelle;

    @Column( name = "niv_accred" )
    private Integer nivAccred;
}

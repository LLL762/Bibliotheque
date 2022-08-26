package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Role.
 */
@Entity
@Table
@Getter
@Setter
public
class Role
{
    /**
     * The Id.
     */
    @Id
    
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    /**
     * The Libelle.
     */
    @Column( name = "libelle", length = 50 )
    private String libelle;

    /**
     * The Niv accred.
     */
    @Column( name = "niv_accred" )
    private Integer nivAccred;
}

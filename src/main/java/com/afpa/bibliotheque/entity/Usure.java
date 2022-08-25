package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The type Usure.
 */
@Entity
@Table( name = "usure" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Usure
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
    /* @TODO : Nom de l'état du livre à définir dans une énum ? */
    @Column( name = "libelle", length = 50 )
    private String libelle;

    /**
     * The Description.
     */
    @ToString.Exclude
    @Column( name = "description", length = 500 )
    private String description;
}

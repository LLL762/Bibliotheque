package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The type Bibliotheque.
 */
@Entity
@Table( name = "biblioteque" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Bibliotheque
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
     * The Adresse.
     */
    @Column( name = "adresse", length = 500 )
    private String adresse;
}

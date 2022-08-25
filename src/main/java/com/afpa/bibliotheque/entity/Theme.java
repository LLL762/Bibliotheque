package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The type Theme.
 */
@Entity
@Table( name = "theme" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Theme
{
    /**
     * The Id.
     */
    /* @TODO : Considèrer la possibilité d'avoir un thème temporaire */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    /**
     * The Libellé.
     */
    @Column( name = "libelle", length = 50 )
    private String libellé;

    /**
     * The Description.
     */
    @ToString.Exclude
    @Column( name = "description", length = 500 )
    private String description;
}

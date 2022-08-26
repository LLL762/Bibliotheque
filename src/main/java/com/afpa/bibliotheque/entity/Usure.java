package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The type Usure.
 */
@Entity
@Table(name = "usure")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Usure {

    /**
     * The Id.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The Nom.
     */
    /* @TODO : Nom de l'état du livre à définir dans une énum ? */
    @Column(name = "nom", length = 50, nullable = false, unique = true)
    private String nom;

    /**
     * The Description.
     */
    @ToString.Exclude
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "description", length = 500)
    private String description;
}

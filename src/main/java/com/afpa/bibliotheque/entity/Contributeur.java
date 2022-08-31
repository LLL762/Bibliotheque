package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 18/07/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@Setter
@Table(name = "contributeur")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contributeur {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The Nom.
     */
    private String nom;
    /**
     * The Prenom.
     */
    private String prenom;

    private String pseudo;

}

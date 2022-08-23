package com.afpa.bibliotheque.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 18/07/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@Setter
public class Auteur {

    /**
     * The Id.
     */
    private Long id;
    /**
     * The Nom.
     */
    private String nom;
    /**
     * The Prenom.
     */
    private String prenom;

}

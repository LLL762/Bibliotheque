package com.afpa.bibliotheque.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * 18/07/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livre {

    /**
     * The Id.
     */
    private Long id;
    /**
     * The Isbn.
     */
    private Long isbn;
    /**
     * The Titre.
     */
    private String titre;
    /**
     * The Icon url.
     */
    private String iconUrl;
    /**
     * The Theme.
     */
    private Theme theme;

    /**
     * The Auteurs.
     */
    private Set<Auteur> auteurs = new HashSet<>();


}

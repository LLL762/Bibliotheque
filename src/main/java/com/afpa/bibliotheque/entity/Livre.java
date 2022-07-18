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

    private Long id;
    private Long isbn;
    private String titre;
    private String iconUrl;
    private Theme theme;

    private Set<Auteur> auteurs = new HashSet<>();


}

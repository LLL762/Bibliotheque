package com.afpa.bibliotheque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * 18/07/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Livre {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @ToString.Exclude
//    private Theme theme;

    /**
     * The Auteurs.
     */
//    private Set<Contributeur> contributeurs = new HashSet<>();


}

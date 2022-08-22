package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * 18/07/2022.
 *
 * @author Laurent Lamiral
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "livre")
@ToString
public class Livre {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    /**
     * The Isbn.
     */

    @Column(nullable = false, unique = true)
    @NaturalId
    private Long isbn;
    /**
     * The Titre.
     */
    @Column
    private String titre;
    /**
     * The Icon url.
     */
    @Column
    private String iconUrl;
    /**
     * The Theme.
     */
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_theme")
    @ToString.Exclude
    private Theme theme;

    /**
     * The Auteurs.
     */
//    private Set<Auteur> auteurs = new HashSet<>();


}

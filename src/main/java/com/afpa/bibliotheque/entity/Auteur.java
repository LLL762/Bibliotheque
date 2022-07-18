package com.afpa.bibliotheque.entity;

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
@NoArgsConstructor
@AllArgsConstructor
public class Auteur {

    private Long id;
    private String nom;
    private String prenom;

}

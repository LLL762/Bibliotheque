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
public class Theme {

    /**
     * The Id.
     */
    private Long id;
    /**
     * The Nom.
     */
    private String nom;
    /**
     * The Description.
     */
    private String description;


}

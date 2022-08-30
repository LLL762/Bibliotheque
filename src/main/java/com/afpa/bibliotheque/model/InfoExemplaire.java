package com.afpa.bibliotheque.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 30/08/2022.
 *
 * @author Laurent Lamiral
 */
@Data
@RequiredArgsConstructor
public class InfoExemplaire {

    private Integer idExemplaire;
    private Long isbn;

    private Long idLivre;
    private String titre;
    private String theme;
    private String emplacement;
    private String bibliotheque;
    private String commentaireExemplaire;

    private String contributeurs;


    public InfoExemplaire(Integer idExemplaire, Long isbn, Long idLivre, String titre, String theme, String emplacement, String bibliotheque, String commentaireExemplaire) {
        this.idExemplaire = idExemplaire;
        this.isbn = isbn;
        this.idLivre = idLivre;
        this.titre = titre;
        this.theme = theme;
        this.emplacement = emplacement;
        this.bibliotheque = bibliotheque;
        this.commentaireExemplaire = commentaireExemplaire;
    }
}

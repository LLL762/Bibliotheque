package com.afpa.bibliotheque.repo.jpql;

/**
 * 30/08/2022.
 *
 * @author Laurent Lamiral
 */
public final class ExemplaireJPQL {

    public static final String GET_INFO_EXEMPLAIRE = """
            SELECT new com.afpa.bibliotheque.model.InfoExemplaire(exemplaire.id, livre.isbn, livre.id, livre.titre,
            bibliotheque.libelle, theme.libelle, emplacement.libelle, exemplaire.commentaire)
            FROM Exemplaire exemplaire
            JOIN exemplaire.emplacement emplacement
            JOIN emplacement.bibliotheque bibliotheque
            JOIN exemplaire.livre livre
            LEFT JOIN exemplaire.emprunt emprunt
            JOIN livre.theme theme
            WHERE exemplaire.id = :id
            """;

    private ExemplaireJPQL() {
    }


}

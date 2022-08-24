package com.afpa.bibliotheque.repo;

public final class JPQLQuery {

    public static String LIVRE_PARAM_TITRE = "titre";
    public static String LIVRE_FIND_BY_TITRE = "SELECT livre FROM Livre livre WHERE livre.titre = :" +
            LIVRE_PARAM_TITRE;


    private JPQLQuery() {
    }


}

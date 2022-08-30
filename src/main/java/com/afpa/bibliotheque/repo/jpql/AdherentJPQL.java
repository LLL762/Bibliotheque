package com.afpa.bibliotheque.repo.jpql;

public final class AdherentJPQL {

    public static final String ID_PARAM = "id";
    public static final String GET_BY_ID = "SELECT adherent FROM Adherent adherent WHERE adherent.id = :" + ID_PARAM;


    private AdherentJPQL() {

    }
}

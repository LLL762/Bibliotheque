package com.afpa.bibliotheque.jpatool;

import jakarta.persistence.EntityManager;

public final class JpaUtilities {

    private JpaUtilities() {
    }

    public static void closeEntityManager(final EntityManager em) {

        if (em != null && em.isOpen()) {
            em.close();
        }

    }


}

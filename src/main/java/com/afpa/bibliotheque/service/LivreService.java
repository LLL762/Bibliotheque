package com.afpa.bibliotheque.service;


import com.afpa.bibliotheque.entity.Livre;
import com.afpa.bibliotheque.repo.LivreRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class LivreService {
    private final EntityManagerFactory emf;
    private final LivreRepo livreRepo;


    public List<Livre> findByTitre(final String titre) {

        EntityManager em = null;
        List<Livre> output;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            output = livreRepo.findByTitre(titre.trim(), em);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return output;
    }


}

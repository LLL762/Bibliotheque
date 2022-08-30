package com.afpa.bibliotheque.service.impl;

import com.afpa.bibliotheque.model.InfoExemplaire;
import com.afpa.bibliotheque.repo.ExemplaireRepo;
import com.afpa.bibliotheque.service.ExemplaireService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * 30/08/2022.
 *
 * @author Laurent Lamiral
 */
@RequiredArgsConstructor
public class ExemplaireServiceImpl implements ExemplaireService {

    private final ExemplaireRepo exemplaireRepo;
    private final EntityManagerFactory emf;

    @Override
    public Optional<InfoExemplaire> getExemplaireInfo(final Integer exemplaireId) {

        EntityManager em = null;
        Optional<InfoExemplaire> output;

        try {
            em = emf.createEntityManager();

            em.getTransaction().begin();
            output = exemplaireRepo.getInfoExemplaire(exemplaireId, em);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return output;
    }
}

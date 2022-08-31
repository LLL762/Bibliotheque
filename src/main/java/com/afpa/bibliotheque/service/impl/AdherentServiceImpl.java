package com.afpa.bibliotheque.service.impl;

import com.afpa.bibliotheque.entity.Emprunt;
import com.afpa.bibliotheque.entity.Utilisateur;
import com.afpa.bibliotheque.repo.AdherentRepo;
import com.afpa.bibliotheque.service.AdherentService;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class AdherentServiceImpl implements AdherentService {

    private final AdherentRepo adherentRepo;
    private final EntityManagerFactory emf;

    @Override
    public Optional<Utilisateur> findAdherentById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Utilisateur> getInfoAdherent(Integer id) {

        EntityManager em = null;
        Optional<Utilisateur> output;

        try {
            em = emf.createEntityManager();

            EntityGraph<?> entityGraph = em.getEntityGraph("adherent-fetch-emprunts");
            Map<String, Object> hints = new HashMap<>();
            hints.put("javax.persistence.fetchgraph", entityGraph);

            em.getTransaction().begin();
            output = adherentRepo.findAdherentById(id, em, hints);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return output;
    }

    @Override
    public boolean canEmprunter(final Integer adherentId) {

        return false;
    }


    @Override
    public void addEmprunt(Utilisateur adherent, Emprunt emprunt) {

        throw new UnsupportedOperationException();
    }
}

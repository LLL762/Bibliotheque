package com.afpa.bibliotheque.service.impl;

import com.afpa.bibliotheque.model.InfoEmprunt;
import com.afpa.bibliotheque.repo.EmpruntRepo;
import com.afpa.bibliotheque.service.EmpruntService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmpruntServiceImpl implements EmpruntService {

    private final EmpruntRepo empruntRepo;
    private final EntityManagerFactory emf;


    @Override
    public List<InfoEmprunt> getInfoEmprunt(List<Long> ids) {
        EntityManager em = null;
        List<InfoEmprunt> output;


        try {
            em = emf.createEntityManager();

            em.getTransaction().begin();
            output = empruntRepo.getInfoEmprunts(ids, em).stream().toList();
            em.getTransaction().commit();

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return output;
    }
}

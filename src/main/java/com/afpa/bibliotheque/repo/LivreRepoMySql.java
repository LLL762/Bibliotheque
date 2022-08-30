package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.entity.Livre;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static com.afpa.bibliotheque.repo.JPQLQuery.LIVRE_FIND_BY_TITRE;
import static com.afpa.bibliotheque.repo.JPQLQuery.LIVRE_PARAM_TITRE;

public class LivreRepoMySql implements LivreRepo {

    @Override
    public List<Livre> findByTitre(final String titre, final EntityManager em) {

        return em.createQuery(LIVRE_FIND_BY_TITRE, Livre.class)
                .setParameter(LIVRE_PARAM_TITRE, titre)
                .getResultList();
    }

    @Override
    public Optional<Livre> findById(Long id, EntityManager em) {

        return Optional.ofNullable(em.find(Livre.class, id));
    }


}

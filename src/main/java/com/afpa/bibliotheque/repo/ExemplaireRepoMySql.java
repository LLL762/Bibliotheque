package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.model.InfoExemplaire;
import com.afpa.bibliotheque.repo.jpql.ExemplaireJPQL;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.Optional;

/**
 * 30/08/2022.
 *
 * @author Laurent Lamiral
 */
public class ExemplaireRepoMySql implements ExemplaireRepo {


    @Override
    public Optional<InfoExemplaire> getInfoExemplaire(Integer id, EntityManager em) {

        try {
            final InfoExemplaire result = em.createQuery(ExemplaireJPQL.GET_INFO_EXEMPLAIRE, InfoExemplaire.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.of(result);

        } catch (NoResultException e) {

            return Optional.empty();
        }


    }
}

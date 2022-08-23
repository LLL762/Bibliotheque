package com.afpa.bibliotheque.jpatool;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.afpa.bibliotheque.jpatool.JpaUtilities.closeEntityManager;

@Getter
@RequiredArgsConstructor
public class CriteriaQueryBuilder {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibli-persistence-unit");


    public <T, S> CriteriaQuery<T> buildFindByQuery(final Class<T> tClass, final String fieldName, final S fieldValue) {

        EntityManager em = null;
        try {

            em = emf.createEntityManager();
            final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(tClass);
            final Root<T> root = criteriaQuery.from(tClass);

            return criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(fieldName), fieldValue));
        } finally {
            closeEntityManager(em);
        }
    }


}

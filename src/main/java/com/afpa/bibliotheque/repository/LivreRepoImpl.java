package com.afpa.bibliotheque.repository;

import com.afpa.bibliotheque.entity.Livre;
import com.afpa.bibliotheque.jpatool.CriteriaQueryBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernateHints;

import java.util.List;


public class LivreRepoImpl {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibli-persistence-unit");


    public Livre create(final Livre livre) {

        final EntityManager em = emf.createEntityManager();
        Livre output;
        em.getTransaction().begin();
        output = em.merge(livre);
        em.getTransaction().commit();

        return output;
    }

    public Livre find() {

        final EntityManager em = emf.createEntityManager();
        Livre output;
        em.getTransaction().begin();
        output = em.find(Livre.class, 1L);

        em.getTransaction().commit();
        return output;
    }


    public List<Livre> findByTitle(final String title) {

        final EntityManager em = emf.createEntityManager();


        TypedQuery<Livre> query = em.createQuery(new CriteriaQueryBuilder().buildFindByQuery(Livre.class, "titre", title))
                .setHint(HibernateHints.HINT_READ_ONLY, true);

        List<Livre> results = query.getResultList();


        em.close();

        return results;
    }


}

package com.afpa.bibliotheque.repository;

import com.afpa.bibliotheque.entity.Livre;
import com.afpa.bibliotheque.entity.Theme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.jpa.HibernateHints;

import java.util.List;


public class LivreRepo {

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


        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Livre> q = cb.createQuery(Livre.class);

        Root<Livre> root = q.from(Livre.class);
        q.select(root).where(cb.equal(root.get("titre"), title));

        TypedQuery<Livre> query = em.createQuery(q).setHint(HibernateHints.HINT_READ_ONLY, true);
        List<Livre> results = query.getResultList();

        Theme robert = results.get(0).getTheme();
        System.out.println(robert != null ? robert.getNom() : "!!!!");

        em.close();

        return results;
    }


}

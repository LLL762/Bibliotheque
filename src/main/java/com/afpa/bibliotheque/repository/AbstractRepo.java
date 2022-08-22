package com.afpa.bibliotheque.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractRepo<T, S> {

    private final EntityManagerFactory emf;

    public Optional<T> findById(final S id) {

        final EntityManager em = emf.createEntityManager();
        T outputValue;

        em.getTransaction().begin();


        em.getTransaction().commit();

        return Optional.empty();

    }


}

package com.afpa.bibliotheque.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractRepo<T, S> {


    private final Class<T> typeClass;

    public Optional<T> findById(final S id, final EntityManager em) {

        return Optional.ofNullable(em.find(typeClass, id));


    }


}

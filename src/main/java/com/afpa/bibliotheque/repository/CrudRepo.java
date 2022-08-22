package com.afpa.bibliotheque.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepo<T, S> {

    Optional<T> findById(final S id);

    List<T> getAll(final int pageSize);

    T save(T entity);


}

package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.entity.Livre;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public interface LivreRepo {

    List<Livre> findByTitre(String titre, EntityManager em);

    Optional<Livre> findById(Long id, EntityManager em);


}

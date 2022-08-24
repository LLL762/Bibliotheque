package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.entity.Livre;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface LivreRepo {

    List<Livre> findByTitre(String titre, EntityManager em);

}

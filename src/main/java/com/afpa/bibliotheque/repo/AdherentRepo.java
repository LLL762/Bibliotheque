package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.entity.Utilisateur;
import jakarta.persistence.EntityManager;

import java.util.Map;
import java.util.Optional;

public interface AdherentRepo {

    Optional<Utilisateur> findAdherentById(Integer id, EntityManager em);

    Optional<Utilisateur> findAdherentById(Integer id, EntityManager em, Map<String, Object> hints);

    Utilisateur save(Utilisateur adherent, EntityManager em);

}

package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.entity.Utilisateur;
import jakarta.persistence.EntityManager;

import java.util.Map;
import java.util.Optional;


public class AdherentRepoMySql implements AdherentRepo {

    @Override
    public Optional<Utilisateur> findAdherentById(Integer id, EntityManager em) {

        return Optional.ofNullable(em.find(Utilisateur.class, id));
    }

    @Override
    public Optional<Utilisateur> findAdherentById(Integer id, EntityManager em, Map<String, Object> hints) {

        return Optional.ofNullable(em.find(Utilisateur.class, id, hints));
    
    }


    @Override
    public Utilisateur save(Utilisateur adherent, EntityManager em) {

        return em.merge(adherent);

    }


}

package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.model.InfoExemplaire;
import jakarta.persistence.EntityManager;

import java.util.Optional;

/**
 * 30/08/2022.
 *
 * @author Laurent Lamiral
 */
public interface ExemplaireRepo {

    Optional<InfoExemplaire> getInfoExemplaire(Integer id, EntityManager em);


}

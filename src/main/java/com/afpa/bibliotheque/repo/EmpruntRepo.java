package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.model.InfoEmprunt;
import jakarta.persistence.EntityManager;

import java.util.Collection;
import java.util.List;

public interface EmpruntRepo {

    Collection<InfoEmprunt> getInfoEmprunts(List<Long> ids, EntityManager em);


}

package com.afpa.bibliotheque.repo;

import com.afpa.bibliotheque.model.InfoEmprunt;
import com.afpa.bibliotheque.repo.jpql.EmpruntJPQL;
import jakarta.persistence.EntityManager;

import java.util.Collection;
import java.util.List;

public class EmpruntRepoMySql implements EmpruntRepo {


    @Override
    public Collection<InfoEmprunt> getInfoEmprunts(List<Long> ids, EntityManager em) {

        return em.createQuery(EmpruntJPQL.GET_INFO_EMPRUNT, InfoEmprunt.class)
                .setParameter("ids", ids)
                .getResultList();
    }


}

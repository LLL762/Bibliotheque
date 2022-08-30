package com.afpa.bibliotheque.container;

import com.afpa.bibliotheque.repo.AdherentRepo;
import com.afpa.bibliotheque.repo.AdherentRepoMySql;
import com.afpa.bibliotheque.repo.EmpruntRepo;
import com.afpa.bibliotheque.repo.EmpruntRepoMySql;
import com.afpa.bibliotheque.service.AdherentService;
import com.afpa.bibliotheque.service.EmpruntService;
import com.afpa.bibliotheque.service.impl.AdherentServiceImpl;
import com.afpa.bibliotheque.service.impl.EmpruntServiceImpl;
import com.afpa.bibliotheque.utility.HibernateUtil;
import lombok.Getter;

@Getter
public enum AppContainer {

    INSTANCE;
    private final AdherentRepo adherentRepo = new AdherentRepoMySql();
    private final AdherentService adherentService = new AdherentServiceImpl(adherentRepo, HibernateUtil.EMF);

    private final EmpruntRepo empruntRepo = new EmpruntRepoMySql();
    private final EmpruntService empruntService = new EmpruntServiceImpl(empruntRepo, HibernateUtil.EMF);

}

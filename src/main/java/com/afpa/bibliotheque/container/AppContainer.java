package com.afpa.bibliotheque.container;

import com.afpa.bibliotheque.repo.*;
import com.afpa.bibliotheque.service.AdherentService;
import com.afpa.bibliotheque.service.EmpruntService;
import com.afpa.bibliotheque.service.ExemplaireService;
import com.afpa.bibliotheque.service.LivreService;
import com.afpa.bibliotheque.service.impl.AdherentServiceImpl;
import com.afpa.bibliotheque.service.impl.EmpruntServiceImpl;
import com.afpa.bibliotheque.service.impl.ExemplaireServiceImpl;
import com.afpa.bibliotheque.utility.HibernateUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum AppContainer {


    INSTANCE;

    private final LivreRepo livreRepo = new LivreRepoMySql();
    private final LivreService livreService = new LivreService(HibernateUtil.EMF, livreRepo);

    private final AdherentRepo adherentRepo = new AdherentRepoMySql();
    private final AdherentService adherentService = new AdherentServiceImpl(adherentRepo, HibernateUtil.EMF);

    private final EmpruntRepo empruntRepo = new EmpruntRepoMySql();
    private final EmpruntService empruntService = new EmpruntServiceImpl(empruntRepo, HibernateUtil.EMF);

    private final ExemplaireRepo exemplaireRepo = new ExemplaireRepoMySql();
    private final ExemplaireService exemplaireService = new ExemplaireServiceImpl(exemplaireRepo, HibernateUtil.EMF);

    public void load() {
        log.info("container loaded");
    }

}

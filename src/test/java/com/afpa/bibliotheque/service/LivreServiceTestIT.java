package com.afpa.bibliotheque.service;

import com.afpa.bibliotheque.repo.LivreRepoMySql;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class LivreServiceTestIT {

    private final LivreRepoMySql repo = new LivreRepoMySql();
    private final LivreService service = new LivreService(Persistence.createEntityManagerFactory("wtf"), repo);

    @Test
    void findByTitre() {

        fail();


    }
}
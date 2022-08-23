package com.afpa.bibliotheque.service;

import com.afpa.bibliotheque.entity.Exemplaire;

import java.util.List;

public interface ExemplaireService {

    List<Exemplaire> searchExemplaire(final String searchValue);


}

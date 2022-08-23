package com.afpa.bibliotheque.repository;

import com.afpa.bibliotheque.entity.Exemplaire;
import com.afpa.bibliotheque.entity.Livre;

import java.util.List;

public interface LivreRepo {
    List<Livre> searchByTitle(String title);

    List<Livre> searchByISBN(String isbn);

    List<Exemplaire> getListExemplaire(Livre livre);


}

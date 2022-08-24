package com.afpa.bibliotheque.model;

import com.afpa.bibliotheque.entity.Livre;
import com.afpa.bibliotheque.service.LivreService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter

public class SearchLivreModel {


    @Getter(AccessLevel.NONE)
    private final LivreService livreService;
    private List<Livre> searchResult;


    @Setter
    private String searchValue;


    public void searchLivre() {
        searchResult = livreService.findByTitre(searchValue);
    }


}

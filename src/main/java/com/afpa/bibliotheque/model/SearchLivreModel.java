package com.afpa.bibliotheque.model;

import com.afpa.bibliotheque.entity.Exemplaire;
import com.afpa.bibliotheque.service.ExemplaireService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class SearchLivreModel {


    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final ExemplaireService exemplaireService;
    private List<Exemplaire> searchResult;
    @Setter
    private String searchValue;


    private void search() {

        List<Exemplaire> newSearchResult = exemplaireService.searchExemplaire(searchValue);

        pcs.firePropertyChange("search-result-change", this.searchResult, newSearchResult);
        searchResult = newSearchResult;


    }


    public void addPropertyChangeListener(PropertyChangeListener pcl) {

        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

    public PropertyChangeListener[] getObservers() {

        return pcs.getPropertyChangeListeners();

    }


}

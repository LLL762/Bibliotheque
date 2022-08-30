package com.afpa.bibliotheque.model;

import com.afpa.bibliotheque.entity.Utilisateur;
import lombok.Data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

@Data
public class InfoAdherentModel implements AppObservable {


    public static final String ADHERENT_CHANGE_PROPERTY = "adherent-change";
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private Utilisateur adherent;
    private List<InfoEmprunt> infoEmprunt = new ArrayList<>();


    public void setAdherent(Utilisateur adherent) {
        pcs.firePropertyChange(ADHERENT_CHANGE_PROPERTY, this.adherent, adherent);
        this.adherent = adherent;
    }
    

    @Override
    public void addPropertyChangeListener(final PropertyChangeListener pcl) {

        pcs.addPropertyChangeListener(pcl);

    }

    @Override
    public void removePropertyChangeListener(final PropertyChangeListener pcl) {

        pcs.removePropertyChangeListener(pcl);

    }

    @Override
    public PropertyChangeListener[] getObserver() {
        return pcs.getPropertyChangeListeners();
    }
}

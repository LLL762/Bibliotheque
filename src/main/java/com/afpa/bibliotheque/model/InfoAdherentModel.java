package com.afpa.bibliotheque.model;

import com.afpa.bibliotheque.entity.Emprunt;
import com.afpa.bibliotheque.entity.Utilisateur;
import com.afpa.bibliotheque.service.EmpruntService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class InfoAdherentModel implements AppObservable {


    public static final String ADHERENT_CHANGE_PROPERTY = "adherent-change";
    private final EmpruntService empruntService;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private Utilisateur adherent;
    private List<InfoEmprunt> infoEmprunt = new ArrayList<>();


    public void setAdherent(final Utilisateur adherent) {
        fetchInfoEmprunt(adherent);
        pcs.firePropertyChange(ADHERENT_CHANGE_PROPERTY, this.adherent, adherent);
        this.adherent = adherent;
    }


    private void fetchInfoEmprunt(Utilisateur adherent) {
        infoEmprunt = empruntService.getInfoEmprunt(adherent.getEmprunts().stream().map(Emprunt::getId).toList());
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

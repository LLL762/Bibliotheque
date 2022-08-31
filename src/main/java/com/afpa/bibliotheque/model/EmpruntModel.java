package com.afpa.bibliotheque.model;

import com.afpa.bibliotheque.entity.Contributeur;
import com.afpa.bibliotheque.entity.ContributeurContribution;
import com.afpa.bibliotheque.entity.Contribution;
import com.afpa.bibliotheque.service.LivreService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.stream.Collectors;

/**
 * 30/08/2022.
 *
 * @author Laurent Lamiral
 */

@RequiredArgsConstructor
public class EmpruntModel implements AppObservable {

    public static final String EXEMPLAIRE_CHANGED_PROPERTY = "exemplaire changed";
    private final LivreService livreService;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    @Getter
    private InfoExemplaire infoExemplaire;

    @Getter
    private String contributeursDisplay;


    public void setInfoExemplaire(InfoExemplaire infoExemplaire) {

        updateContributeursDisplays(infoExemplaire);
        pcs.firePropertyChange(EXEMPLAIRE_CHANGED_PROPERTY, this.infoExemplaire, infoExemplaire);

        this.infoExemplaire = infoExemplaire;
    }

    private void updateContributeursDisplays(final InfoExemplaire newValue) {

        contributeursDisplay = livreService.findById(newValue.getIdLivre()).stream().map(this::formatContribs).collect(Collectors.joining(", "));

    }

    private String formatContribs(final ContributeurContribution cc) {

        final Contributeur contributeur = cc.getContributeur();
        final Contribution contribution = cc.getContribution();
        final String contributeurdisplay = (contributeur.getNom() != null && contributeur.getPrenom() != null) ?
                contributeur.getNom() + " " + contributeur.getPrenom() : contributeur.getPseudo();

        return contributeurdisplay + " : " + contribution.getLibelle();
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

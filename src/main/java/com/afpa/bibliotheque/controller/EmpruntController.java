package com.afpa.bibliotheque.controller;

import com.afpa.bibliotheque.container.AppContainer;
import com.afpa.bibliotheque.model.EmpruntModel;
import com.afpa.bibliotheque.model.InfoExemplaire;
import com.afpa.bibliotheque.service.ExemplaireService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.Setter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Character.isDigit;

/**
 * 19/07/2022.
 *
 * @author Laurent Lamiral
 */
public class EmpruntController implements Initializable, PropertyChangeListener {
    private static final int MAX_NUM_EXEMPLAIRE_LENGTH = 10;
    @FXML
    private Label bibliothequeLabel;
    @FXML
    private Label commentaireLabel;
    @FXML
    private Label contributeursLabel;
    @FXML
    private Label emplacementLabel;
    @FXML
    private Button empruntBtn;
    @FXML
    private Label idExemplaireLabel;
    @FXML
    private Label isbnLabel;
    @FXML
    private TextField searchBar;
    @FXML
    private Button searchBtn;
    @FXML
    private Label themeLabel;
    @FXML
    private Label titreLabel;

    @FXML
    private Label message;

    private ExemplaireService exemplaireService;

    @Setter
    private EmpruntModel empruntModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    public void init() {

        exemplaireService = AppContainer.INSTANCE.getExemplaireService();
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> checkSearchBarContent(oldValue, newValue));
        empruntModel = new EmpruntModel(AppContainer.INSTANCE.getLivreService());

        empruntModel.addPropertyChangeListener(this);

    }

    void checkSearchBarContent(String oldValue, String newValue) {
        if (!newValue.isEmpty()) {
            searchBar.setText(newValue.length() <= MAX_NUM_EXEMPLAIRE_LENGTH &&
                    isDigit(newValue.charAt(newValue.length() - 1)) ? newValue : oldValue);
        }
    }

    @FXML
    void emprunt() {


    }

    @FXML
    void search() {
        try {
            final int idToSearch = Integer.parseInt(searchBar.getText());
            final Optional<InfoExemplaire> infos = exemplaireService.getExemplaireInfo(idToSearch);

            if (infos.isPresent()) {
                empruntModel.setInfoExemplaire(infos.get());
                message.setText("");
            } else {
                message.setText("Not found!");
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            message.setText("Error!");
        }

    }

    public void updateInfoExemplaire(final InfoExemplaire infoExemplaire) {
        bibliothequeLabel.setText(infoExemplaire.getBibliotheque());
        commentaireLabel.setText(infoExemplaire.getCommentaireExemplaire());
        emplacementLabel.setText(infoExemplaire.getEmplacement());
        idExemplaireLabel.setText(infoExemplaire.getIdExemplaire().toString());
        isbnLabel.setText(infoExemplaire.getIsbn().toString());
        themeLabel.setText(infoExemplaire.getTheme());
        titreLabel.setText(infoExemplaire.getTitre());
        contributeursLabel.setText(empruntModel.getContributeursDisplay());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals(EmpruntModel.EXEMPLAIRE_CHANGED_PROPERTY)) {
            updateInfoExemplaire((InfoExemplaire) evt.getNewValue());

        }

    }
}





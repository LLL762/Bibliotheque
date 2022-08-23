package com.afpa.bibliotheque.view;

import com.afpa.bibliotheque.entity.Livre;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static javafx.scene.layout.Priority.ALWAYS;
import static javafx.scene.layout.Priority.NEVER;

public class ListeLivreGenerator {

    public HBox createLivreItem(final Livre livre) {
        final HBox output = new HBox();
        final Image imgIcon = new Image(livre.getIconUrl());
        final ImageView icon = new ImageView(imgIcon);

        final VBox champs = new VBox();
        final Label titre = new Label(livre.getTitre());
        final Label theme = new Label(livre.getTheme().getNom());

        output.setAlignment(Pos.CENTER_LEFT);
        output.setSpacing(30.0);
        output.getStyleClass().add("livre-item");

        VBox.setVgrow(output, NEVER);

        icon.setPreserveRatio(true);
        HBox.setHgrow(icon, NEVER);

        HBox.setHgrow(champs, ALWAYS);


        return output;

// TODO : gerer le cas d'une url invalide ou null et construire une methode gerant les images.
// TODO : creer une variable globale font-size.
// TODO : ajouter la liste (ou une partie) des auteurs.


    }

    public VBox createLivreDetails(final Livre livre) {
        final VBox output = new VBox();

        return output;
    }


    public HBox createLivreDetail(final String fieldName, final String fieldValue) {
        final HBox output = new HBox();
        final Label fieldNameLabel = new Label(fieldName);
        final Label fieldValueLabel = new Label(fieldValue);


        return output;
    }


}

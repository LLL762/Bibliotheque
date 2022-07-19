package com.afpa.bibliotheque.controller;

import com.afpa.bibliotheque.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 19/07/2022.
 *
 * @author Laurent Lamiral
 */
public class AdherentController {

    /**
     * Fxml loader pour la scene emprunt .
     */

    private final FXMLLoader statsLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_RECHERCHE_EMPRUNT.fxml"));
    /**
     * TableView contenant une liste de livre.
     */
    @FXML
    private TableView<?> livreTableView;


    /**
     * Go to emprunt scene.
     *
     * @throws IOException
     */
    public void goToEmprunt() throws IOException {

        changeScene(statsLoader);

    }

    /**
     * Change the current scene.
     *
     * @param fxmlLoader fxml loader
     * @throws IOException
     */
    private void changeScene(final FXMLLoader fxmlLoader) throws IOException {

        final Parent root = fxmlLoader.load();
        final Stage stage;
        final Scene scene;

        stage = (Stage) livreTableView.getScene().getWindow();

        stage.setScene(new Scene(root, livreTableView.getScene().getWidth(), livreTableView.getScene().getHeight()));


    }

}

package com.afpa.bibliotheque.controller;

import com.afpa.bibliotheque.HelloApplication;
import javafx.animation.Animation.Status;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavMenuController implements Initializable {


    private final FXMLLoader statsLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_STATISTIQUE.fxml"));
    private final FXMLLoader adherentLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_FICHE_ADHERANT.fxml"));
    private final FXMLLoader empruntLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_RECHERCHE_EMPRUNT.fxml"));
    private final FXMLLoader listeLivreLoader = new FXMLLoader(HelloApplication.class.getResource("liste-livres.fxml"));
    private final TranslateTransition translateButton = new TranslateTransition();
    @FXML
    private Button displayMenuButton;
    @FXML
    private VBox menuVBox;
    @FXML
    private HBox mainContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();

    }

    public void init() {

        translateButton.setNode(mainContainer);
        translateButton.setDuration(Duration.millis(375));
        translateButton.setOnFinished(e -> displayMenuButton.setDisable(false));

    }


    public void goToStats() throws IOException {

        changeScene(statsLoader);


    }


    @FXML
    void goToAdherent() throws IOException {

        changeScene(adherentLoader);


    }

    @FXML
    void goToEmprunt() throws IOException {

        changeScene(empruntLoader);


    }

    @FXML
    void goToListeLivre() throws IOException {

        changeScene(listeLivreLoader);


    }

    private void changeScene(final FXMLLoader fxmlLoader) throws IOException {

        final Parent root = fxmlLoader.load();
        final Stage stage;
        final Scene scene;

        stage = (Stage) mainContainer.getScene().getWindow();

        stage.setScene(new Scene(root, mainContainer.getScene().getWidth(), mainContainer.getScene().getHeight()));


    }


    @FXML
    private void displayMenu() {

        // TO DO refactor .

        if (translateButton.getStatus() == Status.RUNNING) {

            return;
        }

        if (displayMenuButton.getText().equals("<")) {

            displayMenuButton.setText(">");

            menuVBox.setDisable(true);

            translateButton.setByX(-mainContainer.getBoundsInLocal().getWidth() + displayMenuButton.getBoundsInLocal().getWidth());

        } else {

            displayMenuButton.setText("<");
            menuVBox.setDisable(false);

            translateButton.setByX(mainContainer.getBoundsInLocal().getWidth() - displayMenuButton.getBoundsInLocal().getWidth());

        }

        displayMenuButton.setDisable(true);

        translateButton.play();

    }

}

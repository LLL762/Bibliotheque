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

/**
 * The type Nav menu controller.
 */
public class NavMenuController implements Initializable {


    /**
     * Fxml loader de la scene stats.
     */
    private final FXMLLoader statsLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_STATISTIQUE.fxml"));
    /**
     * Fxml loader de la scene adherent.
     */
    private final FXMLLoader adherentLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_FICHE_ADHERANT.fxml"));
    /**
     * Fxml loader de la scene gestion livre.
     */
    private final FXMLLoader gestionLivreLoader = new FXMLLoader(HelloApplication.class.getResource("modification.fxml"));
    /**
     * Fxml loader de la scene liste livre.
     */
    private final FXMLLoader listeLivreLoader = new FXMLLoader(HelloApplication.class.getResource("liste-livres.fxml"));

    /**
     * Fxml loader de la scene gestion home.
     */
    private final FXMLLoader homeLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


    /**
     * Animation de transition cachant ou revelant le menu.
     */
    private final TranslateTransition translateMenu = new TranslateTransition();

    /**
     * Bouton déclenchant {@link #translateMenu }
     */
    @FXML
    private Button displayMenuButton;
    /**
     * Vbox contenant le menu.
     */
    @FXML
    private VBox menuVBox;
    /**
     * Conteneur principal.
     */
    @FXML
    private HBox mainContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTranslateMenu();

    }

    /**
     * Init {@link #translateMenu }.
     */
    public void initTranslateMenu() {

        translateMenu.setNode(mainContainer);
        translateMenu.setDuration(Duration.millis(375));
        translateMenu.setOnFinished(e -> displayMenuButton.setDisable(false));

    }


    /**
     * Go to stats scene.
     *
     * @throws IOException
     */
    public void goToStats() throws IOException {

        changeScene(statsLoader);


    }


    /**
     * Go to adherent scene.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void goToAdherent() throws IOException {

        changeScene(adherentLoader);


    }

    /**
     * Go to gestion livre scene.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void goToGestionLivre() throws IOException {

        changeScene(gestionLivreLoader);

    }


    /**
     * Go to home scene.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void goToHome() throws IOException {
        changeScene(homeLoader);

    }

    /**
     * Go to liste livre scene.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void goToListeLivre() throws IOException {
        changeScene(listeLivreLoader);

    }

    /**
     * Change scene.
     *
     * @param fxmlLoader fxml loader
     * @throws IOException
     */
    private void changeScene(final FXMLLoader fxmlLoader) throws IOException {

        final Parent root = fxmlLoader.load();
        final Stage stage;
        final Scene scene;

        stage = (Stage) mainContainer.getScene().getWindow();

        stage.setScene(new Scene(root, mainContainer.getScene().getWidth(), mainContainer.getScene().getHeight()));


    }


    /**
     * Action assignée à {@link #displayMenuButton}, l'animation montre ou cache le menu selon son etat.
     * Durant l'animation le menu et le bouton sont inaccessible.
     * Si le menu est caché il devient inacessible (pas de focus).
     */
    @FXML
    private void displayMenu() {

        // TO DO refactor .

        if (translateMenu.getStatus() == Status.RUNNING) {

            return;
        }

        if (displayMenuButton.getText().equals("<")) {

            displayMenuButton.setText(">");

            menuVBox.setDisable(true);

            translateMenu.setByX(-mainContainer.getBoundsInLocal().getWidth() + displayMenuButton.getBoundsInLocal().getWidth());

        } else {

            displayMenuButton.setText("<");
            menuVBox.setDisable(false);

            translateMenu.setByX(mainContainer.getBoundsInLocal().getWidth() - displayMenuButton.getBoundsInLocal().getWidth());

        }

        displayMenuButton.setDisable(true);

        translateMenu.play();

    }

}

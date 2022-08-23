package com.afpa.bibliotheque.controller;

import com.afpa.bibliotheque.container.SceneContainer;
import javafx.animation.Animation.Status;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
     * Animation de transition cachant ou revelant le menu.
     */
    private final TranslateTransition translateMenu = new TranslateTransition();


    private Stage stage;

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

        changeScene(SceneContainer.INSTANCE.getStatsScene());

    }


    /**
     * Go to adherent scene.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void goToAdherent() throws IOException {

        changeScene(SceneContainer.INSTANCE.getAdherentScene());

    }

    /**
     * Go to gestion livre scene.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void goToGestionLivre() throws IOException {

        changeScene(SceneContainer.INSTANCE.getGestionLivreScene());

    }


    /**
     * Go to home scene.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void goToHome() throws IOException {

        changeScene(SceneContainer.INSTANCE.getHomeScene());

    }

    /**
     * Go to liste livre scene.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void goToListeLivre() throws IOException {


        changeScene(SceneContainer.INSTANCE.getListeLivreScene());

    }


    private void changeScene(final Scene scene) throws IOException {

        final double height = mainContainer.getScene().getWindow().getHeight();
        final double width = mainContainer.getScene().getWindow().getWidth();


        stage = (Stage) mainContainer.getScene().getWindow();
        stage.setScene(scene);
  

        stage.getScene().getWindow().setHeight(height);
        stage.getScene().getWindow().setWidth(width);

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

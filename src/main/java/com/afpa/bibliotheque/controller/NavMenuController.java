package com.afpa.bibliotheque.controller;

import javafx.animation.Animation.Status;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class NavMenuController implements Initializable {

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

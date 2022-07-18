package com.afpa.bibliotheque.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class NavMenuController implements Initializable {

	@FXML
	private Button displayMenuButton;

	@FXML
	private VBox menuVBox;

	@FXML
	private HBox mainContainer;

	private final TranslateTransition translateButton = new TranslateTransition();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();

	}

	public void init() {

		translateButton.setNode(mainContainer);
		translateButton.setDuration(Duration.millis(1000));

	}

	@FXML
	private void displayMenu() {

		// TO DO fix small graphic glitch and refactor .

		if (translateButton.getStatus() == Status.RUNNING) {

			return;
		}

		if (displayMenuButton.getText().equals("<")) {

			displayMenuButton.setText(">");

			translateButton.setByX(-mainContainer.getWidth() + displayMenuButton.getWidth());

		} else {

			displayMenuButton.setText("<");

			translateButton.setByX(mainContainer.getWidth() - displayMenuButton.getWidth());

		}

		translateButton.play();

	}

}

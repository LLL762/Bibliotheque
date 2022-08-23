package com.afpa.bibliotheque.container;

import com.afpa.bibliotheque.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import lombok.Getter;

import java.io.IOException;

@Getter
public enum SceneContainer {

    INSTANCE;

    private final FXMLLoader homeLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    private final FXMLLoader adherentLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_FICHE_ADHERANT.fxml"));
    private final FXMLLoader gestionLivreLoader = new FXMLLoader(HelloApplication.class.getResource("modification.fxml"));
    private final FXMLLoader listeLivreLoader = new FXMLLoader(HelloApplication.class.getResource("liste-livres.fxml"));
    private final FXMLLoader statsLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_STATISTIQUE.fxml"));

    private Scene homeScene;
    private Scene adherentScene;
    private Scene gestionLivreScene;
    private Scene listeLivreScene;
    private Scene statsScene;


    public void init() {
        try {
            homeScene = new Scene(homeLoader.load());
            adherentScene = new Scene(adherentLoader.load());
            gestionLivreScene = new Scene(gestionLivreLoader.load());
            listeLivreScene = new Scene(listeLivreLoader.load());
            statsScene = new Scene(statsLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

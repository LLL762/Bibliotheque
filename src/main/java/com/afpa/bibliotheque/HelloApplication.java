package com.afpa.bibliotheque;

import com.afpa.bibliotheque.entity.Livre;
import com.afpa.bibliotheque.repository.LivreRepo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Hello application.
 */
public class HelloApplication extends Application {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        LivreRepo repo = new LivreRepo();

        Livre livre = new Livre();
        livre.setIsbn(14789L);
        livre.setTitre("toto");

        repo.create(livre);
        System.out.println(repo.findByTitle("toto").get(0));
        System.out.println(repo.findByTitle("Derrick").get(0));

        stage.setTitle("Bibliothèque");
        stage.setScene(scene);
        stage.show();
    }
}

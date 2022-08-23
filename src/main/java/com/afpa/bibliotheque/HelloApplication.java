package com.afpa.bibliotheque;

import com.afpa.bibliotheque.container.SceneContainer;
import com.afpa.bibliotheque.repository.LivreRepoImpl;
import javafx.application.Application;
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


        LivreRepoImpl repo = new LivreRepoImpl();

        System.out.println(repo.findByTitle("Derrick"));


        SceneContainer.INSTANCE.init();

        stage.setTitle("Bibliothèque");
        stage.setScene(SceneContainer.INSTANCE.getHomeScene());
        stage.show();

    }
}

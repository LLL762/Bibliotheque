package com.afpa.bibliotheque;

import com.afpa.bibliotheque.entity.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
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

    public static void commeTuVeux() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wtf");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.find(Livre.class, 1L);
            tx.commit();
        } finally {
            entityManager.close();
        }


    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bibliothèque");
        stage.setScene(scene);
        stage.show();
        commeTuVeux();
    }
}

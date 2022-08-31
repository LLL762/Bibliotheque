package com.afpa.bibliotheque;

import com.afpa.bibliotheque.container.AppContainer;
import com.afpa.bibliotheque.entity.Livre;
import com.afpa.bibliotheque.utility.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * The type Hello application.
 */
@Slf4j
public
class HelloApplication extends Application {
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

    public static void run() {


    }


    @Override
    public void init() {
        log.info("[system] Methode init().");
    }


    @Override
    public void stop() throws Exception {
        final EntityManagerFactory emf = HibernateUtil.EMF;

        if (emf.isOpen()) {
            log.info("Factory closing...");
            emf.close();
            log.info("Factory closed");
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        log.info("loading container....");
        AppContainer.INSTANCE.load();

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Bibliothèque");
        stage.setScene(scene);
        stage.show();
    }


}

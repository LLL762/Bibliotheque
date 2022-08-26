package com.afpa.bibliotheque;

import com.afpa.bibliotheque.controller.SearchLivreController;
import com.afpa.bibliotheque.entity.Livre;
import com.afpa.bibliotheque.model.SearchLivreModel;
import com.afpa.bibliotheque.repo.LivreRepo;
import com.afpa.bibliotheque.repo.LivreRepoMySql;
import com.afpa.bibliotheque.service.LivreService;
import com.afpa.bibliotheque.utility.HibernateUtil;
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
public
class HelloApplication extends Application
{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static
    void main( String[] args )
    {
        launch();
    }

    public static
    void commeTuVeux()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "wtf" );

        EntityManager     entityManager = emf.createEntityManager();
        EntityTransaction tx            = entityManager.getTransaction();

        try
        {
            tx.begin();
            entityManager.find( Livre.class, 1L );
            tx.commit();
        }
        finally
        {
            entityManager.close();
        }

    }

    public static
    void run()
    {

        LivreRepo    livreRepo    = new LivreRepoMySql();
        LivreService livreService = new LivreService( HibernateUtil.EMF, livreRepo );

        System.out.println( livreService.findByTitre( "Arnold" ) );

    }

    @Override
    public
    void init()
    {
        System.out.println( "[system] Methode init()." );
    }

    @Override
    public
    void start( Stage stage ) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication.class.getResource( "hello-view.fxml" ) );

        LivreRepo        livreRepo        = new LivreRepoMySql();
        LivreService     livreService     = new LivreService( HibernateUtil.EMF, livreRepo );
        SearchLivreModel searchLivreModel = new SearchLivreModel( livreService );

        Scene                 scene      = new Scene( fxmlLoader.load() );
        SearchLivreController controller = fxmlLoader.getController();
        controller.setModel( searchLivreModel );
        controller.setText();


        stage.setTitle( "Bibliothèque" );
        stage.setScene( scene );
        stage.show();
    }
}

package com.afpa.bibliotheque.controller;


import com.afpa.bibliotheque.model.SearchLivreModel;
import com.afpa.bibliotheque.repo.JPQLQuery;
import com.afpa.bibliotheque.utility.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.Setter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchLivreController implements Initializable {

    String recherche = "";
    @Setter
    private SearchLivreModel model;
    @FXML
    private Label testLabel;
    @FXML
    private TextField saisie;
    @FXML
    private ListView listeResultats;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setText() {
        model.setSearchValue("Revecca");
        model.searchLivre();
        testLabel.setText(model.getSearchResult().toString());
    }

    public void rechercher() {
        EntityManagerFactory emf = HibernateUtil.EMF;
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            recherche = saisie.getText();
            List query = entityManager.createQuery(JPQLQuery.LIVRE_FIND_BY_TITRE)
                    .setParameter("titre", recherche)
                    .getResultList();
            System.out.println(query);

            listeResultats.getItems().add(query);
            tx.commit();
        } finally {
            entityManager.close();
        }
    }

}

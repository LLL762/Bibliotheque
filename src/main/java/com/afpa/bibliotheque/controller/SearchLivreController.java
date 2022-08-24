package com.afpa.bibliotheque.controller;


import com.afpa.bibliotheque.model.SearchLivreModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchLivreController implements Initializable {

    @Setter
    private SearchLivreModel model;
    @FXML
    private Label testLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setText() {
        model.setSearchValue("Revecca");
        model.searchLivre();
        testLabel.setText(model.getSearchResult().toString());
    }


}

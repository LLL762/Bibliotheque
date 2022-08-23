package com.afpa.bibliotheque.controller;

import com.afpa.bibliotheque.model.SearchLivreModel;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;


public class SearchBarController {


    private SearchLivreModel searchLivreModel;
    @FXML
    private ComboBox<String> orderCombo;

    @FXML
    private ComboBox<String> orderParamCombo;

    @FXML
    private Spinner<Integer> pageSizeSpinner;

    @FXML
    private TextField searchTextField;

    @FXML
    void search() {

        searchLivreModel.setSearchValue(searchTextField.getText());

    }

    public void init() {

    }


}

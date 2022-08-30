package com.afpa.bibliotheque.controller;

import com.afpa.bibliotheque.HelloApplication;
import com.afpa.bibliotheque.container.AppContainer;
import com.afpa.bibliotheque.entity.Utilisateur;
import com.afpa.bibliotheque.model.InfoAdherentModel;
import com.afpa.bibliotheque.model.InfoEmprunt;
import com.afpa.bibliotheque.service.AdherentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.Setter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Character.isDigit;

/**
 * 19/07/2022.
 *
 * @author Laurent Lamiral
 */
public class AdherentController implements Initializable, PropertyChangeListener {

    /**
     * Fxml loader pour la scene emprunt .
     */

    private static final int MAX_NUM_ADHERENT_LENGTH = 10;

    private final FXMLLoader statsLoader = new FXMLLoader(HelloApplication.class.getResource("VUE_RECHERCHE_EMPRUNT.fxml"));
    private final ObservableList<InfoEmprunt> tableViewContent = FXCollections.observableArrayList();
    /**
     * TableView contenant une liste de livre.
     */

    @FXML
    private Label adresse;
    @FXML
    private Label countEmprunts;
    @FXML
    private Label dateExpiration;
    @FXML
    private TableColumn<InfoEmprunt, LocalDate> datePretCol;
    @FXML
    private TableColumn<InfoEmprunt, LocalDate> dateRetourCol;
    @FXML
    private TableColumn<InfoEmprunt, String> bibliothequeCol;
    @FXML
    private TableColumn<InfoEmprunt, Integer> codeExemplaireCol;
    @FXML
    private TableColumn<InfoEmprunt, Long> isbnCol;
    @FXML
    private TableColumn<InfoEmprunt, String> titreCol;
    @FXML
    private TableView<InfoEmprunt> livreTableView;
    @FXML
    private Label email;
    @FXML
    private Label message;
    @FXML
    private Label nom;
    @FXML
    private Label numeroAdhr;
    @FXML
    private Label prenom;
    @FXML
    private TextField searchBar;
    @FXML
    private Button searchButton;
    @FXML
    private Label telephone;
    private AdherentService adherentService;

    @Setter
    private InfoAdherentModel infoAdherent = new InfoAdherentModel();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        init();

    }


    public void init() {
        adherentService = AppContainer.INSTANCE.getAdherentService();

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> checkSearchBarContent(oldValue, newValue));
        infoAdherent.addPropertyChangeListener(this);
        message.setText("");
        initTableView();
    }

    private void initTableView() {
        datePretCol.setCellValueFactory(new PropertyValueFactory<>("datePret"));
        dateRetourCol.setCellValueFactory(new PropertyValueFactory<>("dateRetour"));
        bibliothequeCol.setCellValueFactory(new PropertyValueFactory<>("bibliotheque"));
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        codeExemplaireCol.setCellValueFactory(new PropertyValueFactory<>("exemplaireId"));
        titreCol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        livreTableView.setItems(tableViewContent);
    }


    void checkSearchBarContent(String oldValue, String newValue) {

        if (!newValue.isEmpty()) {
            searchBar.setText(newValue.length() <= MAX_NUM_ADHERENT_LENGTH &&
                    isDigit(newValue.charAt(newValue.length() - 1)) ? newValue : oldValue);
        }
    }

    @FXML
    void searchAdherent() {

        try {
            final int idToSearch = Integer.parseInt(searchBar.getText());
            final Optional<Utilisateur> adherent = adherentService.getInfoAdherent(idToSearch);

            adherent.ifPresentOrElse(utilisateur -> {
                infoAdherent.setAdherent(adherent.get());
                message.setText("");
            }, () -> message.setText("Not found!"));

        } catch (NumberFormatException e) {
            e.printStackTrace();
            message.setText("Error!");
        }

    }


    private void updateInfoAdherent(final Utilisateur newAdherent) {
        prenom.setText(newAdherent.getPrenom());
        nom.setText(newAdherent.getNom());
        numeroAdhr.setText(newAdherent.getId().toString());
        adresse.setText(newAdherent.getAdresse());
        telephone.setText(newAdherent.getTelephone().toString());
        dateExpiration.setText(newAdherent.getDateFinAdhesion().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    void updateInfoEmprunts() {

        tableViewContent.setAll(infoAdherent.getInfoEmprunt());

    }


    /**
     * Go to emprunt scene.
     *
     * @throws IOException
     */
    @FXML
    public void goToEmprunt() throws IOException {

        changeScene(statsLoader);

    }

    /**
     * Change the current scene.
     *
     * @param fxmlLoader fxml loader
     * @throws IOException
     */
    private void changeScene(final FXMLLoader fxmlLoader) throws IOException {

        final Parent root = fxmlLoader.load();
        final Stage stage;
      

        stage = (Stage) livreTableView.getScene().getWindow();

        stage.setScene(new Scene(root, livreTableView.getScene().getWidth(), livreTableView.getScene().getHeight()));


    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals(InfoAdherentModel.ADHERENT_CHANGE_PROPERTY)) {
            updateInfoAdherent((Utilisateur) evt.getNewValue());
            updateInfoEmprunts();
        }
    }
}

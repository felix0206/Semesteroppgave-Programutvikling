package Fxml;

import Hjelpeklasser.AdminInnlegging;
import Hjelpeklasser.KundeModell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminSideController implements Initializable {

    @FXML
    public Button Start;

    @FXML
    public TableColumn Navn, Email, TypeBil, Hestekrefter, Interior, Farge, Felger, Pris;

    @FXML
    private TableView<AdminInnlegging> tabell;

    @FXML
    public TextField typebil, hestekrefter, interior, farge, felger, pris;


    HovedsideController hovedsideController = new HovedsideController();

    public void StartSide(ActionEvent event) throws IOException {

        Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

        Scene scene = new Scene(kundeSide);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public ObservableList<AdminInnlegging> getKunde(){


        ObservableList<AdminInnlegging> kunde = FXCollections.observableArrayList();
        kunde.add(new AdminInnlegging(typebil.getText(), hestekrefter.getText(), interior.getText(), farge.getText(),felger.getText(), pris.getText()));

        return kunde;

    }


    public void LeggTil(ActionEvent event) {

        TypeBil.setCellValueFactory(new PropertyValueFactory<>("typebil"));
        Hestekrefter.setCellValueFactory(new PropertyValueFactory<>("hestekrefter"));
        Interior.setCellValueFactory(new PropertyValueFactory<>("interior"));
        Farge.setCellValueFactory(new PropertyValueFactory<>("farge"));
        Felger.setCellValueFactory(new PropertyValueFactory<>("felger"));
        Pris.setCellValueFactory(new PropertyValueFactory<>("pris"));

        tabell.setItems(getKunde());

    }
}

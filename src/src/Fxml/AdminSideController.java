package Fxml;

import Hjelpeklasser.AdminCollection;
import Hjelpeklasser.AdminInnlegging;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
    public TextField typebil, hestekrefter, interior, farge, felger, pris, filtrer;

    HovedsideController hovedsideController = new HovedsideController();
    AdminCollection collection = new AdminCollection();

    public void StartSide(ActionEvent event) throws IOException {

        Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

        Scene scene = new Scene(kundeSide);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collection.setTable(tabell);
    }


    public void LeggTil(ActionEvent event) {

        AdminInnlegging legginn = registreringTable();

        if (legginn != null){
            reset();
            collection.leggtil(legginn);
        }

    }

    public void Slett(ActionEvent event){
        tabell.getItems().removeAll(tabell.getSelectionModel().getSelectedItems()); //sletter valgt rad klikk på rad og så slett
    }

    public void Clear(ActionEvent event){
        reset();
    }

   /* public void filtrer(){
        tabell.setItems(collection.filtrer());
    } */

    private AdminInnlegging registreringTable(){
        AdminInnlegging reg = new AdminInnlegging(null, 0,null,null,null,0);

        String typebilText = typebil.getText();
        int hestekrefterText = Integer.parseInt(hestekrefter.getText());
        String interiorText = interior.getText();
        String fargeText = farge.getText();
        String felgerText = felger.getText();
        int prisText = Integer.parseInt(pris.getText());

        reg.typebil(typebilText);
        reg.hestekrefter(hestekrefterText);
        reg.interior(interiorText);
        reg.farge(fargeText);
        reg.felger(felgerText);
        reg.pris(prisText);

        return reg;
    }

    private void reset(){
        typebil.setText("");
        hestekrefter.setText("");
        interior.setText("");
        farge.setText("");
        felger.setText("");
        pris.setText("");
    }
}

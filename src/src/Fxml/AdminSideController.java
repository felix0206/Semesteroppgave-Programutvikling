package Fxml;

import Hjelpeklasser.AdminCollection;
import Hjelpeklasser.AdminInnlegging;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

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

        //tableview rediering
        tabell.setEditable(true);
        TypeBil.setCellFactory(TextFieldTableCell.forTableColumn());
        Hestekrefter.setCellFactory(TextFieldTableCell.forTableColumn());
        Interior.setCellFactory(TextFieldTableCell.forTableColumn());
        Farge.setCellFactory(TextFieldTableCell.forTableColumn());
        Felger.setCellFactory(TextFieldTableCell.forTableColumn());
        Pris.setCellFactory(TextFieldTableCell.forTableColumn());

        collection.leggtil(new AdminInnlegging("el","140","sport", "gul","sport","150000"));
        collection.leggtil(new AdminInnlegging("Bensin","750","sport", "Rød","sport","850000"));
    }

    //metodene som forsikrer at cellene blir endret når man klikker enter
    public void redigerBil(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setTypebil(redigeringFullfort.getNewValue().toString());
    }

    public void redigerHestekrefter(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setHestekrefter(redigeringFullfort.getNewValue().toString());
    }

    public void redigerInterior(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setInterior(redigeringFullfort.getNewValue().toString());
    }

    public void redigerFarge(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setFarge(redigeringFullfort.getNewValue().toString());
    }

    public void redigerFelger(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setFelger(redigeringFullfort.getNewValue().toString());
    }

    public void redigerPris(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setPris(redigeringFullfort.getNewValue().toString());
    }

    //legg inn fra textbox
    public void LeggTil(ActionEvent event) {

        AdminInnlegging legginn = registreringTable();

        if (legginn != null){
            reset();
            collection.leggtil(legginn);
        }

    }

    //slette knapp som fjerner valgt rad i tableview
    public void Slett(ActionEvent event){
        tabell.getItems().removeAll(tabell.getSelectionModel().getSelectedItems()); //sletter valgt rad klikk på rad og så slett
    }

    //reset knapp som fjerner alt skrevet i textboxene
    public void Clear(ActionEvent event){
        reset();
    }

    //filtrering i TextBox
    public void Filtrering(KeyEvent event){
        ObservableList<AdminInnlegging> liste = FXCollections.observableArrayList();
        FilteredList<AdminInnlegging> filter = new FilteredList<>(liste, p -> true);

        filtrer.textProperty().addListener(((observable, oldValue, newValue) -> {
            filter.setPredicate(AdminInnlegging ->{
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String input = newValue.toLowerCase();
                if(AdminInnlegging.getTypebil().toLowerCase().indexOf(input) != -1){
                    return true;
                }
                if(AdminInnlegging.getHestekrefter().toLowerCase().indexOf(input) != -1){
                    return true;
                }
                if(AdminInnlegging.getInterior().toLowerCase().indexOf(input) != -1){
                    return true;
                }
                if(AdminInnlegging.getFarge().toLowerCase().indexOf(input) != -1){
                    return true;
                }
                if(AdminInnlegging.getFelger().toLowerCase().indexOf(input) != -1){
                    return true;
                }
                if(AdminInnlegging.getPris().toLowerCase().indexOf(input) != -1){
                    return true;
                }
                return false;
            });
            SortedList<AdminInnlegging> sortering = new SortedList<>(filter);
            sortering.comparatorProperty().bind(tabell.comparatorProperty());
            tabell.setItems(sortering);
        }));
    }

    //registrering av ny bil
    private AdminInnlegging registreringTable(){
        AdminInnlegging reg = new AdminInnlegging( null, null,null,null,null,null);

        //String navnText = navn.getText();
        //String emailText = email.getText();
        String typebilText = typebil.getText();
        String hestekrefterText = hestekrefter.getText();
        String interiorText = interior.getText();
        String fargeText = farge.getText();
        String felgerText = felger.getText();
        String prisText = pris.getText();

        //reg.navn(navnText);
        //reg.email(emailText);
        reg.typebil(typebilText);
        reg.hestekrefter(hestekrefterText);
        reg.interior(interiorText);
        reg.farge(fargeText);
        reg.felger(felgerText);
        reg.pris(prisText);

        return reg;
    }

    //resetter alle textboxene.
    private void reset(){
        typebil.setText("");
        hestekrefter.setText("");
        interior.setText("");
        farge.setText("");
        felger.setText("");
        pris.setText("");
    }
}

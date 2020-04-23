package Fxml;

import Hjelpeklasser.AdminCollection;
import Hjelpeklasser.AdminInnlegging;
import Hjelpeklasser.Exceptions;
import save_load.FileSaverCsv;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminSideController implements Initializable {

    @FXML
    public Button Start;

    @FXML
    public TableColumn<AdminInnlegging, String> Navn, Email, TypeBil, Hestekrefter, Interior, Farge, Felger, Pris;

    @FXML
    private TableView<AdminInnlegging> tabell;

    @FXML
    public TextField typebil, hestekrefter, interior, farge, felger, pris, filtrer;

    @FXML
    public MenuItem savefile, loadfile;

    HovedsideController hovedsideController = new HovedsideController();
    AdminCollection collection = new AdminCollection();
    StringBuilder sb = new StringBuilder();

    //knapp for å komme tilbake til forsiden
    @FXML
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

        try {
            readCSV();
        }catch (Exceptions exceptions){
            exceptions.NoSuchFileException("Feil fil eller feil delimiter (;)");
        }
        //tableview rediering
        tabell.setEditable(true);
        TypeBil.setCellFactory(TextFieldTableCell.forTableColumn());
        Hestekrefter.setCellFactory(TextFieldTableCell.forTableColumn());
        Interior.setCellFactory(TextFieldTableCell.forTableColumn());
        Farge.setCellFactory(TextFieldTableCell.forTableColumn());
        Felger.setCellFactory(TextFieldTableCell.forTableColumn());
        Pris.setCellFactory(TextFieldTableCell.forTableColumn());

        TypeBil.setCellValueFactory(new PropertyValueFactory<>("typebil"));
        Hestekrefter.setCellValueFactory(new PropertyValueFactory<>("hestekrefter"));
        Interior.setCellValueFactory(new PropertyValueFactory<>("interior"));
        Farge.setCellValueFactory(new PropertyValueFactory<>("farge"));
        Felger.setCellValueFactory(new PropertyValueFactory<>("felger"));
        Pris.setCellValueFactory(new PropertyValueFactory<>("pris"));

        tabell.setItems(collection.liste);

        tabell.getColumns().addAll(
                TypeBil, Hestekrefter, Interior, Farge, Felger, Pris);


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
    @FXML
    public void LeggTil(ActionEvent event) {

        AdminInnlegging legginn = registreringTable();

        if (legginn != null){
            reset();
            collection.leggtil(legginn);
        }

    }

    //slette knapp som fjerner valgt rad i tableview
    @FXML
    public void Slett(ActionEvent event){
        tabell.getItems().removeAll(tabell.getSelectionModel().getSelectedItems()); //sletter valgt rad klikk på rad og så slett
    }

    //reset knapp som fjerner alt skrevet i textboxene
    @FXML
    public void Clear(ActionEvent event){
        reset();
    }

    //filtrering i TextBox
    FilteredList<AdminInnlegging> filter = new FilteredList(collection.liste, p -> true);

    public void Filtrering(KeyEvent event){

        filtrer.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(adm ->{
                if(newValue.isEmpty() || newValue == null){
                    return true;
                }
                //String input = newValue.toLowerCase();
                if(adm.getTypebil().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getHestekrefter().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getInterior().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getFarge().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getFelger().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getPris().toLowerCase().contains(newValue)){
                    return true;
                }
                return false;
            });
            SortedList<AdminInnlegging> sortering = new SortedList<>(filter);
            sortering.comparatorProperty().bind(tabell.comparatorProperty());
            tabell.setItems(sortering);
        });
    }

    //lagrer til fil
    public void SaveFile(ActionEvent event) throws IOException {
        FileSaverCsv lagre = new FileSaverCsv();
        lagre.lesfil(sb);
    }

    public void LoadFile(ActionEvent event){
        try{
            readCSV();
        }catch (Exceptions exceptions){
            exceptions.NoSuchFileException("Feil filformat eller delimiter (;)!");
        }


    }

    //registrering av ny bil og innlegging i Stringbuilder for lagring til fil
    private AdminInnlegging registreringTable(){

        try {
            AdminInnlegging reg = new AdminInnlegging(null, null, null, null, null, null);

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

            //sb.append("Navn: " + navn + "\n"+"\n" );
            sb.append("Ny Bil: \n" + "Type bil: " + reg.typebil(typebilText) + "\n");
            sb.append("Hestekrefter: " + reg.hestekrefter(hestekrefterText) + "\n");
            sb.append("Interiør: " + reg.interior(interiorText) + "\n");
            sb.append("Farge: " + reg.farge(fargeText) + "\n");
            sb.append("Felger: " + reg.felger(felgerText) + "\n");
            sb.append("Pris: " + reg.pris(prisText) + "\n \n");

            //Sjekker om tekstfeltene er tomme.
            if (
                    reg.getTypebil().isEmpty()|| reg.getHestekrefter().isEmpty() ||
                            reg.getInterior().isEmpty() || reg.getFarge().isEmpty() ||
                            reg.getFelger().isEmpty() || reg.getPris().isEmpty())
            {

                riktigeParametere();

                return null;
            }

            return reg;

        } catch (IllegalArgumentException e){

            riktigeParametere();

            return null;
        }
    }

    //endrer tekstfeltene sånn at admin kan se hvilke parametere som er gyldige
    private void riktigeParametere() {
        typebil.setText("<< elbil, bensin, diesel >>");
        hestekrefter.setText("<< hestekrefter må være heltall >>");
        interior.setText("<< standard, sport, supreme >>");
        farge.setText("<< hvit, svart, rød, bronse >>");
        felger.setText("<< 20, 22, 24 >>");
        pris.setText("<< ugyldig pris >>");
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


    private void readCSV() {

        String CsvFile = "src/src/save_load/testfilcsv.csv";
        String FieldDelimiter = ";";

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);

                AdminInnlegging adminInnlegging = new AdminInnlegging(fields[0], fields[1], fields[2],
                        fields[3], fields[4], fields[5]);
                collection.liste.add(adminInnlegging);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminSideController.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminSideController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }
}
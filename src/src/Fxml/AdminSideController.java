package Fxml;

import Hjelpeklasser.AdminCollection;
import Hjelpeklasser.AdminInnlegging;
import Hjelpeklasser.Exceptions;
import Hjelpeklasser.Tråd;
import javafx.scene.control.cell.*;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminSideController implements Initializable {

    @FXML
    public Button Start;

    @FXML
    public TableColumn<AdminInnlegging, String> Navn, Email, TypeBil, Interior, Farge;

    @FXML
    public TableColumn<AdminInnlegging, Integer> Hestekrefter, Felger, Pris;

    @FXML
    private TableView<AdminInnlegging> tabell;

    @FXML
    public TextField navn, email, typebil, hestekrefter, interior, farge, felger, pris, filtrer;

    @FXML
    public MenuItem savefile, loadfile;

    @FXML
    public Label Parameterelbl;

    AdminCollection collection = new AdminCollection();

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

        //tableview rediering
        /*
        *textfieldtablecell gjør at det dukker opp en textbox når man dobbelt klikker
        * må legge til (new integerstringconverter) for at det skal funke med int verdier
         */
        tabell.setEditable(true); //gjør det mulig å redigere
        Navn.setCellFactory(TextFieldTableCell.forTableColumn());
        Email.setCellFactory(TextFieldTableCell.forTableColumn());
        TypeBil.setCellFactory(TextFieldTableCell.forTableColumn());
        Hestekrefter.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Interior.setCellFactory(TextFieldTableCell.forTableColumn());
        Farge.setCellFactory(TextFieldTableCell.forTableColumn());
        Felger.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Pris.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        Navn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        TypeBil.setCellValueFactory(new PropertyValueFactory<>("typebil"));
        Hestekrefter.setCellValueFactory(new PropertyValueFactory<>("hestekrefter"));
        Interior.setCellValueFactory(new PropertyValueFactory<>("interior"));
        Farge.setCellValueFactory(new PropertyValueFactory<>("farge"));
        Felger.setCellValueFactory(new PropertyValueFactory<>("felger"));
        Pris.setCellValueFactory(new PropertyValueFactory<>("pris"));

        tabell.setItems(collection.liste);

        tabell.getColumns().addAll(
                Navn, Email, TypeBil, Hestekrefter, Interior, Farge, Felger, Pris);

        String msg = "RIKTIGE PARAMETERE: \n \n" +
                "Navn : kan ikke inneholde numre!" + "\n"
                + "Email : noe@noe.noe" + "\n" +
                "Typebil: el, elbil, bensin eller diesel \n" +
                "Hestekrefter: 100 --> 999 \n" +
                "Interior: standard, sport eller supreme \n" +
                "Farge: hvit, svart, rød eller bronse \n" +
                "Felger: 20 --> 25 \n" +
                "Pris: hva som helst (bare tall)";

        Parameterelbl.setText(msg);

    }

    //metodene som forsikrer at cellene blir endret når man klikker enter
    public void redigerNavn(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setNavn(redigeringFullfort.getNewValue().toString());
    }

    public void redigerEmail(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setEmail(redigeringFullfort.getNewValue().toString());
    }

    public void redigerBil(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setTypebil(redigeringFullfort.getNewValue().toString());
    }

    public void redigerHestekrefter(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setHestekrefter(Integer.parseInt(redigeringFullfort.getNewValue().toString()));
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
        valgtCelle.setFelger(Integer.parseInt(redigeringFullfort.getNewValue().toString()));
    }

    public void redigerPris(TableColumn.CellEditEvent redigeringFullfort){
        AdminInnlegging valgtCelle = tabell.getSelectionModel().getSelectedItem();
        valgtCelle.setPris(Integer.parseInt(redigeringFullfort.getNewValue().toString()));
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
        AdminInnlegging valgtElement = tabell.getSelectionModel().getSelectedItem();
        if(valgtElement != null){
            collection.liste.remove(valgtElement);    //sletter valgt rad klikk på rad og så slett
        }

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
                //if setningen som tester om tableviet inneholder "newValue" altså verdien skrevet inn i textboxen filtrer
                if(adm.getNavn().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getEmail().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getTypebil().toLowerCase().contains(newValue)){
                    return true;
                }
                if(adm.getNavn().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getEmail().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(String.valueOf(adm.getHestekrefter()).contains(newValue)){
                    return true;
                }
                else if(adm.getInterior().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(adm.getFarge().toLowerCase().contains(newValue)){
                    return true;
                }
                else if(String.valueOf(adm.getFelger()).contains(newValue)){
                    return true;
                }
                else if(String.valueOf(adm.getPris()).contains(newValue)){
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
        /*
        * lagrer til fil, med prefix path.
        * dermed slipper superbruker å bekymre seg for filplassering
        * gjør at om man lagrer og slår av alt, vil filen være lagret slik at når du åpner adminside vil tableview du lagret bli vist,
         */
        try {
            Thread.sleep(2000);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("File Saved!");
            alert.show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FileWriter fileWriter = new FileWriter("src/src/save_load/kundeDataBase.csv",false);
        fileWriter.write(save(tabell));
        fileWriter.close();
    }

    //metode som henter fil som er lest fra metoden read
    public void LoadFile(ActionEvent event) throws InterruptedException {

        try{
            readCSV();
        }catch (Exceptions exceptions){
            exceptions.NoSuchFileException("Feil filformat eller delimiter (;)!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //registrering av ny bil og innlegging i Stringbuilder for lagring til fil
    private AdminInnlegging registreringTable(){
        AdminInnlegging reg = new AdminInnlegging(null,null,null, 0, null, null, 0, 0);

        try {

            String navnText = navn.getText();
            String emailText = email.getText();
            String typebilText = typebil.getText();
            int hestekrefterText = Integer.parseInt(hestekrefter.getText());
            String interiorText = interior.getText();
            String fargeText = farge.getText();
            int felgerText = Integer.parseInt(felger.getText());
            int prisText = Integer.parseInt(pris.getText());

            reg.navn(navnText);
            reg.email(emailText);
            reg.typebil(typebilText);
            reg.hestekrefter(hestekrefterText);
            reg.interior(interiorText);
            reg.farge(fargeText);
            reg.felger(felgerText);
            reg.pris(prisText);

            //Sjekker om tekstfeltene er tomme.
            if (
                   reg.getNavn().isEmpty() || reg.getEmail().isEmpty() || reg.getTypebil().isEmpty()||
                           reg.getHestekrefter() == null || reg.getInterior().isEmpty() || reg.getFarge().isEmpty() ||
                            reg.getFelger() == null || reg.getPris() == null || reg.getHestekrefter() == 0 ||
                            reg.getFelger() == 0)
            {

               riktigeParametere();

                return null;
            }

            return reg;

        } catch (Exception e){
            riktigeParametere();
            return null;
        }
    }
    //endrer tekstfeltene sånn at admin kan se hvilke parametere som er gyldige
   private void riktigeParametere() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Det ser ut som at det var en feil!");
            alert.setContentText("Noen av tekstfieldene er tomme eller inneholder bokstav der det skal være tall!");
            alert.showAndWait();
    }

    //resetter alle textboxene.
    private void reset(){
        navn.setText("");
        email.setText("");
        typebil.setText("");
        hestekrefter.setText("");
        interior.setText("");
        farge.setText("");
        felger.setText("");
        pris.setText("");
    }

    //metode som leser filen eksempelDataForSensor, bruker bufferreader for å lese filen
    private void readCSV() throws Exception {

        String FieldDelimiter = ";";

        BufferedReader br;

        try {

            Tråd tråd = new Tråd("src/src/save_load/eksempelDataForSensor.csv") ;

            br = new BufferedReader(tråd.call());

            String line;
            while ( (line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);

                AdminInnlegging adminInnlegging = new AdminInnlegging(fields[0], fields[1], fields[2],
                        Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]), Integer.parseInt(fields[7]));
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

    //metode som lagrer tableview i gjeldene tilstand til en string
    private String save(TableView tabellen){

        String ut = "";

        try{
            /*for løkke som henter dirkete fra tableview.
             *gjør at vi både får lagret input, info som er loada fra fil
             *eller data som ligger i tableview fra før
             */
            for(int i = 0; i < collection.liste.size(); i++){
                ut +=    collection.liste.get(i).getNavn()+";"+collection.liste.get(i).getEmail()+";"
                        +collection.liste.get(i).getTypebil()+";" +collection.liste.get(i).getHestekrefter()
                        +";"+collection.liste.get(i).getInterior()+";" +collection.liste.get(i).getFarge()
                        +";"+collection.liste.get(i).getFelger()+";" +collection.liste.get(i).getPris()+"\n";
            }
        }catch (Exceptions exceptions){
            exceptions.wrongInputException("");

        }
        return ut;

    }

    //metode for at admin skal kunne lagre til binær fil.
    public void binarySave() throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg destinasjon");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        String text = save(tabell);
        String utStreng = getBytes(text);
        Stage stage = new Stage();
        stage.setY(250);
        stage.setX(200);

        File file = fileChooser.showSaveDialog(stage);
        File nyFile = new File(file.getAbsolutePath());

        FileOutputStream fil = new FileOutputStream(nyFile);
        fil.write(utStreng.getBytes());
        System.out.println(utStreng);

    }

    //metode for at admin skal kunne laste opp siste lagrede fil. Altså det siste som ble lagret fra tableview.
    public void loadLastSave() throws InterruptedException {
        String FieldDelimiter = ";";

        BufferedReader br;

        try {

            Tråd tråd = new Tråd("src/src/save_load/kundeDataBase.csv") ;

            br = new BufferedReader(tråd.call());

            String line;
            while ( (line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);

                AdminInnlegging adminInnlegging = new AdminInnlegging(fields[0], fields[1], fields[2],
                        Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]), Integer.parseInt(fields[7]));
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

    //hjelpemetoder for å lagre til binær fil.
    static String getBytes(String input){
        String resultat = "";
        byte[] stringBytes = input.getBytes();
        resultat = byteArrayTilBinaryFil(stringBytes);

        return resultat;
    }

    static String byteArrayTilBinaryFil(byte[] array){
        StringBuilder resultat = new StringBuilder();

        for(byte b : array){
            resultat.append(byteToString(b)).append(" ");
        }
        return resultat.toString();
    }

    static String byteToString(byte b){
        return String.format(
                "%8s",
                Integer.toBinaryString(Byte.toUnsignedInt(b)).replace(" ", "0")
        );
    }


}
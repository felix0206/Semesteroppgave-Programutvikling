package Fxml;
import Hjelpeklasser.Exceptions;
import Hjelpeklasser.PrisKalkulator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class KundeSide2Controller {
    Exceptions exceptions = new Exceptions("");

    //oppretter og instansierer de forskjellige dropboksene.
    ObservableList TypeBillist= FXCollections.observableArrayList("Velg Type bil","Elbil", "Bensin" , "Diesel" );
    ObservableList Hestekrefterlist= FXCollections.observableArrayList("Velg Hestekrefter","150", "200" , "300" );
    ObservableList Fargerlist= FXCollections.observableArrayList("Velg Farge","Svart", "Hvit" , "Rød", "Bronse" );
    ObservableList Interiørlist= FXCollections.observableArrayList("Velg Interiør","Standar", "Sport" , "Supreme" );
    ObservableList Felgerlist= FXCollections.observableArrayList("Velg Felger","18", "20" , "24");

    @FXML
    public ChoiceBox Hestekrefterbox;
    @FXML
    public ChoiceBox Fargebox;
    @FXML
    public ChoiceBox Interiørbox;
    @FXML
    public ChoiceBox Felgerbox;
    @FXML
    public ChoiceBox TypeBilbox;
    @FXML
    public Label ValgLabel, boxIkkeValgt;

    @FXML
    public Button Oppsummering, LagreValg;

   public String hester, interior, farge, felger, typebil, navn, epost;

    //initialize metode som kjøres med en gang siden blir lastet inn.
    @FXML
    private void initialize(){
        //gjør knappen som fører til siste side usynlig.
        //denne skal senere bli synlig etter at kunde har bestemt seg for komponenter.
        Oppsummering.setVisible(false);

        //setter value og legger inn i observablelisten.
        Hestekrefterbox.setValue("Velg Hestekrefter");
        Hestekrefterbox.setItems(Hestekrefterlist);

        Fargebox.setValue("Velg Farge");
        Fargebox.setItems(Fargerlist);

        Interiørbox.setValue("Velg Interiør");
        Interiørbox.setItems(Interiørlist);

        Felgerbox.setValue("Velg Felger");
        Felgerbox.setItems(Felgerlist);

        TypeBilbox.setValue("Velg Type bil");
        TypeBilbox.setItems(TypeBillist);

    }


    public void setFargebox(ChoiceBox fargebox) {
        Fargebox = fargebox;
    }

    public void setInteriørbox(ChoiceBox interiørbox) {
        Interiørbox = interiørbox;
    }

    public void setFelgerbox(ChoiceBox felgerbox) {
        Felgerbox = felgerbox;
    }

    /**
     * Setter de forskjellige Strengene som skal sendes videre til neste side.
     */
    public void getHestekrefter(){
        hester = Hestekrefterbox.getValue().toString();
    }
    public void getFarge(){
        farge = Fargebox.getValue().toString();
    }
    public void getFelger(){
        felger = Felgerbox.getValue().toString();
    }
    public void getInterior(){
        interior = Interiørbox.getValue().toString();
    }
    public void getTypeBil(){
        typebil = TypeBilbox.getValue().toString();
    }

    //Metode for å kalle på de forskjellige priskalkulatorene. se hjelpeklasser/prisKalkulator.
    public String getPris(){
        PrisKalkulator prisKalkulator = new PrisKalkulator(typebil.toLowerCase(),farge.toLowerCase()
                                    ,felger.toLowerCase(),interior.toLowerCase(),hester.toLowerCase());
        prisKalkulator.typebilPrisKalk();
        prisKalkulator.fargePrisKalk();
        prisKalkulator.felgePrisKalk();
        prisKalkulator.hesterPrisKalk();
        prisKalkulator.interiorPrisKalk();

        return prisKalkulator.getPris();
    }


    //henter info om person fra forrige side.
    public void hentPersonInfo(String navn, String epost){
        this.navn = navn;
        this.epost = epost;
    }

    //knapp for å gå til oppsummeringssiden hvor bilen og dens komponenter blir listet opp.
    public void Oppsummering(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("FULLFØR KJØP");
        alert.setHeaderText(null);
        alert.setContentText("Fullfør kjøpet? \nklikk ok for fullfør \nklikk cancel for å avbryte");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
        //Oppretter en filewriter for å skrive til csv-filen
        //sånn at admin vil få opp den nye bilen med navn og epost i tableview neste gang den åpnes.
        FileWriter fileWriter = new FileWriter("src/src/save_load/kundeDataBase.csv", true);

        fileWriter.write(navn + ";" + epost + ";" + typebil + ";" + hester + ";" + interior + ";" + farge +
                ";" + felger + ";" + getPris()+"\n");
        fileWriter.close();
        //lukker filewriteren.

        FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSisteSide.fxml"));
        Parent root = loader.load();

        //Henter controlleren til siste siden.
        KundeSisteSideController kundeSisteSideController = loader.getController();

        //Overfører data til siste siden.
        kundeSisteSideController.setValues(hester, farge,interior,felger,typebil,navn,getPris());

        if (farge.equals("Hvit")){
            //Legger inn bilde av bilen på den siste siden
            File file = new File("src/src/Bilder/Hvitbil2.png");
            Image image = new Image(file.toURI().toString());
            kundeSisteSideController.bilde.setImage(image);
        }
        else if(farge.equals("Svart")){
            //Legger inn bilde av bilen på den siste siden
            File file = new File("src/src/Bilder/svartbil.png");
            Image image = new Image(file.toURI().toString());
            kundeSisteSideController.bilde.setImage(image);
        }
        else if (farge.equals("Rød")){
            //Legger inn bilde av bilen på den siste siden
            File file = new File("src/src/Bilder/rødbil.png");
            Image image = new Image(file.toURI().toString());
            kundeSisteSideController.bilde.setImage(image);
        }
        else if(farge.equals("Bronse")){
            //Legger inn bilde av bilen på den siste siden
            File file = new File("src/src/Bilder/bronsebil.png");
            Image image = new Image(file.toURI().toString());
            kundeSisteSideController.bilde.setImage(image);
        }

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();}
        else{
            return;
        }

    }

    //lagrer valgene til brukeren.
    public void LagreValg(ActionEvent event) throws IOException {
        //tester om kunden har valgt en av alle komponenter.
        if (TypeBilbox.getValue().equals("Velg Type bil") || Hestekrefterbox.getValue().equals("Velg Hestekrefter") ||
                Fargebox.getValue().equals("Velg Farge") || Interiørbox.getValue().equals("Velg Interiør") ||
                Felgerbox.getValue().equals("Velg Felger")){

            exceptions.wrongInputException("Feil input!");

            boxIkkeValgt.setText("Du må velge én av alle \nkomponenter!");
        }

        else{
            boxIkkeValgt.setText("");
            Oppsummering.setVisible(true);
            getHestekrefter();
            getFarge();
            getFelger();
            getInterior();
            getTypeBil();
            ValgLabel.setText("Dine valg er lagret. \nTrykk på knappen for å\nvise dine valg og totalpris.");

            LagreValg.setVisible(false);
        }

    }

    public void HjemKnapp(ActionEvent event) throws IOException {
        Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

        Scene scene = new Scene(kundeSide);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}


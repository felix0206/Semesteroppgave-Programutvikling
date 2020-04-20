package Fxml;
import Hjelpeklasser.PrisKalkulator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class KundeSide2Controller {

    ObservableList TypeBillist= FXCollections.observableArrayList("Velg Type bil","Elbil", "Bensin" , "Diesel" );
    ObservableList Hestekrefterlist= FXCollections.observableArrayList("Velg Hestekrefter","150 hk", "200 hk" , "300 hk" );
    ObservableList Fargerlist= FXCollections.observableArrayList("Velg Farge","Svart", "Hvit" , "Rød", "Bronse" );
    ObservableList Interiørlist= FXCollections.observableArrayList("Velg Interiør","Standar", "Sport" , "Supreme" );
    ObservableList Felgerlist= FXCollections.observableArrayList("Velg Felger","18 tommer", "20 tommer" , "24 tommer");

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
    public Label ValgLabel;

    @FXML
    public Button Oppsummering, LagreValg;

   public String hester, interior, farge, felger, typebil, navn;


    @FXML
    private void initialize(){
        Oppsummering.setVisible(false);

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
    public void hentPersonInfo(String navn){
        this.navn = navn;
    }

    //knapp for å gå til oppsummeringssidenm hvor bilen og dens komponenter blir listet opp.
    public void Oppsummering(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSisteSide.fxml"));
        Parent root = loader.load();

        //Henter controlleren til siste siden.
        KundeSisteSideController kundeSisteSideController = loader.getController();

        //Overfører data til siste siden.
        kundeSisteSideController.setValues(hester, farge,interior,felger,typebil,navn,getPris());

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }

    //lagrer valgene til brukeren.
    public void LagreValg(ActionEvent event) {
        Oppsummering.setVisible(true);
        getHestekrefter();
        getFarge();
        getFelger();
        getInterior();
        getTypeBil();
        ValgLabel.setText("Dine valg er lagret. \nTrykk på knappen for å\nvise dine valg og totalpris.");

        LagreValg.setVisible(false);

        System.out.println(hester + " " + farge + " " + felger + " " + interior + " " + typebil );
    }


}


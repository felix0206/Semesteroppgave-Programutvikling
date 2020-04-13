package Fxml;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class KundeSide2Controller {

    ObservableList Hestekrefterlist= FXCollections.observableArrayList("Velg Hestekrefter","150 hk", "200 hk" , "300 hk" );
    ObservableList Fargerlist= FXCollections.observableArrayList("Velg Farge","Svart", "Hvit" , "Rød", "Bronse" );
    ObservableList Interiørlist= FXCollections.observableArrayList("Velg Interiør","Standar", "Sport" , "Supreme" );
    ObservableList Felgerlist= FXCollections.observableArrayList("Velg Felger","18 tommer", "20 tommer" , "24 ");

    @FXML
    public ChoiceBox Hestekrefterbox;
    @FXML
    public ChoiceBox Fargebox;
    @FXML
    public ChoiceBox Interiørbox;
    @FXML
    public ChoiceBox Felgerbox;
    @FXML
    public Label ValgLabel;


   public String hester, interior, farge, felger;


    @FXML
    private void initialize(){

        Hestekrefterbox.setValue("Velg Hestekrefter");
        Hestekrefterbox.setItems(Hestekrefterlist);

        Fargebox.setValue("Velg Farge");
        Fargebox.setItems(Fargerlist);

        Interiørbox.setValue("Velg Interiør");
        Interiørbox.setItems(Interiørlist);

        Felgerbox.setValue("Velg Felger");
        Felgerbox.setItems(Felgerlist);


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



    public void Oppsummering(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSisteSide.fxml"));
        Parent root = loader.load();

        //Henter controlleren til siste siden.
        KundeSisteSideController kundeSisteSideController = loader.getController();

        //Overfører data til siste siden.
        kundeSisteSideController.setValues(hester, farge,interior,felger);

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }

    //lagrer valgene til brukeren.
    public void LagreValg(ActionEvent event) {

        getHestekrefter();
        getFarge();
        getFelger();
        getInterior();
        ValgLabel.setText("Dine valg er lagret.");

        System.out.println(hester + " " + farge + " " + felger + " " + interior);
    }


}


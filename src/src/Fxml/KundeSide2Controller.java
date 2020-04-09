package Fxml;
import com.sun.javafx.scene.control.skin.ChoiceBoxSkin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Observable;

public class KundeSide2Controller {

    ObservableList Hestekrefterlist= FXCollections.observableArrayList("Velg Hestekrefter","150 hk", "200 hk" , "300 hk" );
    ObservableList Fargerlist= FXCollections.observableArrayList("Velg Farge","Svart", "Hvit" , "Rød", "Bronse" );
    ObservableList Interiørlist= FXCollections.observableArrayList("Velg Interiør","Standar", "Sport" , "Supreme" );
    ObservableList Felgerlist= FXCollections.observableArrayList("Velg Felger","18 tommer", "20 tommer" , "24 ");

    @FXML
    private ChoiceBox Hestekrefterbox;
    @FXML
    private ChoiceBox Fargebox;
    @FXML
    private ChoiceBox Interiørbox;
    @FXML
    private ChoiceBox Felgerbox;


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
}


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

    ObservableList Hestekrefterlist= FXCollections.observableArrayList("150 hk", "200 hk" , "300 hk" );

    @FXML
    private ChoiceBox Hestekrefterbox;

    @FXML
    private void initialize(){

        Hestekrefterbox.setValue("Velg Hestekrefter");

        Hestekrefterbox.setItems(Hestekrefterlist);


    }

}

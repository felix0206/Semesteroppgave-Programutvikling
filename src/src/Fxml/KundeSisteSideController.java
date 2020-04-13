package Fxml;

import Hjelpeklasser.FileSaverTxt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class KundeSisteSideController {

    @FXML
    public Label typebil, hestekrefter, felger, farge, interior, pris;


    StringBuilder sb = new StringBuilder();

    public void hjemKnapp(ActionEvent event) throws IOException {

        Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

        Scene scene = new Scene(kundeSide);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }

    //Lagre info om bilen til en txt-fil.
    public void SaveToFile(ActionEvent event) throws IOException {

        FileSaverTxt lagre = new FileSaverTxt();
        lagre.lesfil(sb);

    }
}

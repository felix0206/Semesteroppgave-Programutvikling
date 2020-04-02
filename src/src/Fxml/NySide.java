package Fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NySide {

    @FXML
    private Button Tilbake;


    public void Tilbake(ActionEvent event) throws IOException {

        Parent tilbake = FXMLLoader.load(getClass().getResource("HovedSide.fxml"));

        Scene scene = new Scene(tilbake);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }


}
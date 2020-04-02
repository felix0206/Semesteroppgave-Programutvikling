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



public class HovedsideController {

    @FXML
    public Button nySide;

    public void nySide(ActionEvent event) throws IOException {

        Parent nyside = FXMLLoader.load(getClass().getResource("nySide.fxml"));

        Scene scene = new Scene(nyside);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

}
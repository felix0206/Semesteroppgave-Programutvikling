package Fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartSideController {


    public void LoggInn(ActionEvent event) throws IOException {


        Parent kundeSide = FXMLLoader.load(getClass().getResource("HovedSide.fxml"));

        Scene scene = new Scene(kundeSide);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();


    }

    public void OmOss(ActionEvent event) throws IOException {

        Parent kundeSide = FXMLLoader.load(getClass().getResource("OmOss.fxml"));

        Scene scene = new Scene(kundeSide);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}
package Fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartSideController {

    //knapp for å komme videre til innlogging.
    public void LoggInn(ActionEvent event) throws IOException {


        Parent kundeSide = FXMLLoader.load(getClass().getResource("HovedSide.fxml"));

        Scene scene = new Scene(kundeSide);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();


    }

    //knapp for å komme videre til priser og info siden.
    public void priserOgInfo(ActionEvent event) throws IOException{

        Parent kundeSide = FXMLLoader.load(getClass().getResource("priserOgInfo.fxml"));

        Scene scene = new Scene(kundeSide);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }
}

package Fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

public class kundeSideController {

    @FXML
    private Button Tilbake, videre1;
    private CheckBox Elbilcheck, Hybridcheck, Benisncheck;


    public void Tilbake(ActionEvent event) throws IOException {

        Parent tilbake = FXMLLoader.load(getClass().getResource("HovedSide.fxml"));

        Scene scene = new Scene(tilbake);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);

        window.show();

    }


    public void Videre1(ActionEvent actionEvent) throws IOException {

        Parent videre1= FXMLLoader.load(getClass().getResource("KundeSide2.fxml"));

        Scene scene = new Scene(videre1);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(scene);

        window.show();



    }

    public void Hybridcheck(ActionEvent actionEvent) {

    }

    public void Bensincheck(ActionEvent actionEvent) {
    }

    public void Elbilcheck(ActionEvent actionEvent) {
    }
}

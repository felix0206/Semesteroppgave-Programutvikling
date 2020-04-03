package Fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;



public class HovedsideController {

    @FXML
    public Button Kunde, admin;
    @FXML
    public TextField brukernavn, passord, fornavn, etternavn, epost;


    public void kundeSide(ActionEvent event) throws IOException {

        Parent kundeSide = FXMLLoader.load(getClass().getResource("kundeSide.fxml"));

        Scene scene = new Scene(kundeSide);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    public void adminSide(ActionEvent event) throws IOException {

        if (brukernavn.getText().equals("admin")  && passord.getText().equals("admin")){

            Parent adminSide = FXMLLoader.load(getClass().getResource("AdminSide.fxml"));

            Scene scene = new Scene(adminSide);


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();

        }else{
            brukernavn.setText("Feil Brukernavn!");
            passord.setText("Feil Passord");
        }

    }



}

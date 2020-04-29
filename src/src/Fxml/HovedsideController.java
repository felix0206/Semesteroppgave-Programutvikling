package Fxml;

import Hjelpeklasser.Exceptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


public class HovedsideController {

    @FXML
    public Button Kunde, admin;
    @FXML
    public TextField brukernavn, passord, fornavn, etternavn, epost;
    @FXML
    public Label FeilmeldingAdmin, overskrift;

    String numberRegex = "(.)*(\\d)(.)*";  //For å sjekke om navnet inneholder numre.
    String emailRegex = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b"; //for å teste gyldighet på email.

    Exceptions exceptions = new Exceptions("");

    //Knapp får å gå til kundeSiden.
    public void kundeSide(ActionEvent event) throws IOException {


        //Tester om input i navn og email er korrekte.
        if (fornavn.getText().matches(numberRegex) || etternavn.getText().matches(numberRegex)
            || fornavn.getText().isEmpty() || etternavn.getText().isEmpty()){
            exceptions.wrongInputException("Du kan ikke ha nummer i navn");
            fornavn.setText("kan ikke ha numre her");
            etternavn.setText("kan ikke ha numre her");
        }
        if (epost.getText().matches(emailRegex) || epost.getText().isEmpty()){
            epost.setText("eksempel: ola@noe.noe");
            exceptions.wrongInputException("feil i email (ola@noe.noe)");
        }
        //Tester slutt.
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSide2.fxml"));
            Parent root = loader.load();

            //Henter controlleren til neste side.
            KundeSide2Controller kundeSide2Controller = loader.getController();

            //Overfører data om navn til neste side.
            kundeSide2Controller.hentPersonInfo(fornavn.getText() + " " + etternavn.getText(), epost.getText());

            Scene scene = new Scene(root);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }


    }

    //knapp for å gå til adminSiden.
    public void adminSide(ActionEvent event) throws IOException {

        //Sjekker om passord og brukernavn er riktig. Hvis ikke vises det et hint.
        if (brukernavn.getText().equals("admin")  && passord.getText().equals("admin")){

            Parent adminSide = FXMLLoader.load(getClass().getResource("AdminSide.fxml"));

            Scene scene = new Scene(adminSide);


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();

        }else{
            FeilmeldingAdmin.setText("Feil brukernavn eller passord!\nHint: admin, admin"); //viser feilmelding om passordet
                                                                                    // eller brukernavn er feil. + Hint
        }

    }

    //Hjemknapp som er på alle sider øverst i høyre hjørne.
    public void StartSide(ActionEvent event) throws IOException {

        Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

        Scene scene = new Scene(kundeSide);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();


    }

}

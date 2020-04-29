package Fxml;

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

import java.io.FileWriter;
import java.io.IOException;


public class HovedsideController {

    @FXML
    public Button Kunde, admin;
    @FXML
    public TextField brukernavn, passord, fornavn, etternavn, epost;
    @FXML
    public Label FeilmeldingAdmin, overskrift;

    //Knapp får å gå til kundeSiden.
    public void kundeSide(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSide2.fxml"));
        Parent root = loader.load();

        //Henter controlleren til neste side.
        KundeSide2Controller kundeSide2Controller = loader.getController();

        //Overfører data om navn til neste side.
        kundeSide2Controller.hentPersonInfo(fornavn.getText() + " " + etternavn.getText(), epost.getText());

        //Oppretter en filewriter for å skrive til csv-filen
        //sånn at admin vil få opp den nye bilen med navn og epost i tableview neste gang den åpnes.
       /* FileWriter fileWriter = new FileWriter("src/src/save_load/testfilcsv.csv",true);
        fileWriter.write(fornavn.getText() + " " + etternavn.getText() + ";" + epost.getText() + ";");
        fileWriter.close();*/
        //lukker filewriteren.

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
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

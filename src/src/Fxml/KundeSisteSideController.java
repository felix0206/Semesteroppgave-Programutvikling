package Fxml;

import Hjelpeklasser.FileSaverTxt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KundeSisteSideController implements Initializable {

    @FXML
    public Label typebil, hestekrefter, felger, farge, interior, pris, overskriftlbl;

    String navn;


    StringBuilder sb = new StringBuilder();

    public void hjemKnapp(ActionEvent event) throws IOException {

        Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

        Scene scene = new Scene(kundeSide);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }

    //Oppdaterer StringBuilderen for å lagre til fil.
    public StringBuilder InitData(){

        sb.append("Navn: " + navn + "\n"+"\n" );
        sb.append("Type bil: " + typebil.getText() + "\n"+"\n" );
        sb.append("Hestekrefter: " + hestekrefter.getText() + "\n"+"\n" );
        sb.append("Felger: " + felger.getText() + "\n"+"\n" );
        sb.append("Farge: " + farge.getText() + "\n"+"\n" );
        sb.append("Pris: " + pris.getText() + "\n"+"\n" );

        return sb;
    }

    //Lagre info om bilen til en txt-fil.
    public void SaveToFile(ActionEvent event) throws IOException {

        FileSaverTxt lagre = new FileSaverTxt();
        lagre.lesfil(InitData());

    }

    //Setter verdier fra kundeside2.
    public void setValues(String hester, String farge, String interior, String felger, String typebil, String navn){

        this.hestekrefter.setText(hester);
        this.farge.setText(farge);
        this.interior.setText(interior);
        this.felger.setText(felger);
        this.typebil.setText(typebil);
        overskriftlbl.setText(navn + " sin bil");
        this.navn = navn;

    }

    //Setter verdier fra kundeside.
    public void setValuesKunde1(String typebil){
        this.typebil.setText(typebil);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

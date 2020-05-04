package Fxml;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KundeSisteSideController {

    @FXML
    public Label typebil, hestekrefter, felger, farge, interior, pris, overskriftlbl;

    @FXML
    public ImageView bilde;

    String navn;

    StringBuilder sb = new StringBuilder();


    public void hjemKnapp(ActionEvent event) throws IOException {

        Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

        Scene scene = new Scene(kundeSide);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }


    //Setter verdier fra kundeside2.
    public void setValues(String hester, String farge, String interior, String felger, String typebil, String navn, String pris){

        this.hestekrefter.setText(hester.toLowerCase());
        this.farge.setText(farge.toLowerCase());
        this.interior.setText(interior.toLowerCase());
        this.felger.setText(felger.toLowerCase());
        this.typebil.setText(typebil.toLowerCase());
        this.pris.setText(pris);
        overskriftlbl.setText(navn + " sin bil");
        this.navn = navn;

    }

    //Setter verdier fra kundeside.
    public void setValuesKunde1(String typebil){
        this.typebil.setText(typebil);
    }


}

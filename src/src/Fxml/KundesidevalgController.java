package Fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KundesidevalgController {

    public KundesidevalgController() throws IOException {
    }

    public void LagEgenBil(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSide2.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    //TODO: Lage ferdige biler som kunden kan velge.
    //Dette skal bli lagret til fil og skrives ut sånn at kunden ser sin bestilling.
    //Under er actionevent for de tre forskjellige bilene som er mulig å velge.
    public void VelgBilEn(ActionEvent event) {
    }

    public void VelgBilTo(ActionEvent event) {
    }

    public void VelgBilTre(ActionEvent event) {
    }
}

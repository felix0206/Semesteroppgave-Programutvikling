package Fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class KundesidevalgController implements Initializable {

    public KundesidevalgController(){
    }

    @FXML
    public Button kjøp1, lagrebil1, lagrebil2, kjøp2, lagrebil3, kjøp3;

    public String navn, epost;
    //henter info om person fra forrige side.
    public void hentPersonInfo(String navn, String epost){
        this.navn = navn;
        this.epost = epost;
    }
    public void LagEgenBil(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSide2.fxml"));
        Parent root = loader.load();
        KundeSide2Controller kundeSide2Controller = loader.getController();

        kundeSide2Controller.hentPersonInfo(navn, epost);

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    /*
    her har vi dobbelt opp med knapper for å forsikre om at kunden virkelig vil kjøpe bilen han/hun trykker på.
     */
    public void Lagrebil1(){
        lagrebil1.setVisible(false);
        kjøp1.setVisible(true);

    }
    public void Lagrebil2(){
        lagrebil2.setVisible(false);
        kjøp2.setVisible(true);

    }
    public void Lagrebil3(){
        lagrebil3.setVisible(false);
        kjøp3.setVisible(true);

    }

    public void VelgBilEn(ActionEvent event) throws IOException {

        //Oppretter en filewriter for å skrive til csv-filen
        //sånn at admin vil få opp den nye bilen med navn og epost i tableview neste gang den åpnes.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("FULLFØR KJØP");
        alert.setHeaderText(null);
        alert.setContentText("Fullfør kjøpet? \nklikk ok for fullfør \nklikk cancel for å avbryte");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            FileWriter fileWriter = new FileWriter("src/src/save_load/kundeDataBase.csv", true);

            fileWriter.write(navn + ";" + epost + ";" + "Bensin" + ";" + "150" + ";" + "Standarsd" + ";" + "Hvit" +
                    ";" + "22" + ";" + "340000"+"\n");
            fileWriter.close();
            //lukker filewriteren.

            FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSisteSide.fxml"));
            Parent root = loader.load();

            //Henter controlleren til siste siden.
            KundeSisteSideController kundeSisteSideController = loader.getController();

            //Overfører data til siste siden.
            kundeSisteSideController.setValues("150", "Hvit","Standard","22","Bensin",navn,"340000");

            //Legger inn bilde av bilen på den siste siden
            File file = new File("src/src/Bilder/Hvitbil2.png");
            Image image = new Image(file.toURI().toString());
            kundeSisteSideController.bilde.setImage(image);

            Scene scene = new Scene(root);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        } else {
            return;
        }
    }

    public void VelgBilTo(ActionEvent event) throws IOException {
        //Oppretter en filewriter for å skrive til csv-filen
        //sånn at admin vil få opp den nye bilen med navn og epost i tableview neste gang den åpnes.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("FULLFØR KJØP");
        alert.setHeaderText(null);
        alert.setContentText("Fullfør kjøpet? \nklikk ok for fullfør \nklikk cancel for å avbryte");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            FileWriter fileWriter = new FileWriter("src/src/save_load/kundeDataBase.csv", true);

            fileWriter.write(navn + ";" + epost + ";" + "Elbil" + ";" + "190" + ";" + "Supreme" + ";" + "Rød" +
                    ";" + "20" + ";" + "380000" + "\n");
            fileWriter.close();
            //lukker filewriteren.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSisteSide.fxml"));
            Parent root = loader.load();

            //Henter controlleren til siste siden.
            KundeSisteSideController kundeSisteSideController = loader.getController();

            //Overfører data til siste siden.
            kundeSisteSideController.setValues("190", "Rød", "Supreme", "20", "Elbil", navn, "380000");

            //Legger inn bilde av bilen på den siste siden
            File file = new File("src/src/Bilder/rødbil.png");
            Image image = new Image(file.toURI().toString());
            kundeSisteSideController.bilde.setImage(image);

            Scene scene = new Scene(root);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }
        else {
            return;
        }
    }

    public void VelgBilTre(ActionEvent event) throws IOException {
        //Oppretter en filewriter for å skrive til csv-filen
        //sånn at admin vil få opp den nye bilen med navn og epost i tableview neste gang den åpnes.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("FULLFØR KJØP");
        alert.setHeaderText(null);
        alert.setContentText("Fullfør kjøpet? \nklikk ok for fullfør \nklikk cancel for å avbryte");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            FileWriter fileWriter = new FileWriter("src/src/save_load/kundeDataBase.csv", true);

            fileWriter.write(navn + ";" + epost + ";" + "diesel" + ";" + "254" + ";" + "Sport" + ";" + "Svart" +
                    ";" + "24" + ";" + "420000" + "\n");
            fileWriter.close();
            //lukker filewriteren.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KundeSisteSide.fxml"));
            Parent root = loader.load();

            //Henter controlleren til siste siden.
            KundeSisteSideController kundeSisteSideController = loader.getController();

            //Overfører data til siste siden.
            kundeSisteSideController.setValues("254", "Svart", "Sport", "24", "diesel", navn, "420000");

            //Legger inn bilde av bilen på den siste siden
            File file = new File("src/src/Bilder/svartbil.png");
            Image image = new Image(file.toURI().toString());
            kundeSisteSideController.bilde.setImage(image);

            Scene scene = new Scene(root);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }
        else {
            return;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kjøp1.setVisible(false);
        kjøp2.setVisible(false);
        kjøp3.setVisible(false);
    }

    public void Home(ActionEvent event) throws IOException {
        Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

        Scene scene = new Scene(kundeSide);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}

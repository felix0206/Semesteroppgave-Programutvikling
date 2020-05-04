package Fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KundesidevalgController {
    Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));

    public KundesidevalgController() throws IOException {
    }
}

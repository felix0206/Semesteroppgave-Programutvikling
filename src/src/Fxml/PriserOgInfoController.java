package Fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class PriserOgInfoController {
    Parent kundeSide = FXMLLoader.load(getClass().getResource("StartSide.fxml"));


    public PriserOgInfoController() throws IOException {
    }
}

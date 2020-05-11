package Hjelpeklasser;

import javafx.concurrent.Task;
import javafx.scene.control.Alert;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Tråd extends Task<FileReader>{

    final private String path;

    public Tråd(String path) {
        this.path = path;
    }

    @Override
    public FileReader call() throws InterruptedException {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
                Thread.sleep(3000); //emulerer en "stor" jobb på 3 sekunder...
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("File loaded!");
                alert.show();

        }
        //catcher hvis filen ikke blir funnet. Da kommer det en feilmelding opp.
        catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Error when trying to load file!");
            alert.show();
            e.printStackTrace();
        }

        return fileReader;

    }
}

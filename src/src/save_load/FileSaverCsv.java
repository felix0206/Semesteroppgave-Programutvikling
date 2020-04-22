package save_load;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import save_load.FileSaver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaverCsv implements FileSaver {
    @Override
    public void lesfil(StringBuilder ny) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("FileSaver");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Comma separated values", "*.csv"));

        Stage stage = new Stage();
        stage.setY(250);
        stage.setX(200);

        File file = fileChooser.showSaveDialog(stage);
        File nyFile = new File(file.getAbsolutePath());

        FileWriter fil = new FileWriter(nyFile);
        fil.write(ny.toString());
        fil.close();
    }
}
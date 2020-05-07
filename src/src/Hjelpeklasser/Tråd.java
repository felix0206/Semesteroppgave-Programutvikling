package Hjelpeklasser;

import javafx.concurrent.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tråd extends Task<String>{

    final private String path;

    public Tråd(String path) {
        this.path = path;
    }

    @Override
    public String call() throws Exception {

        String utTekst = "";

        try {
            Thread.sleep(3000); //emulerer en "stor" jobb på 3 sekunder...
        } catch (InterruptedException e) {

        }

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                utTekst = scanner.nextLine();
            }
            scanner.close();

        } catch(FileNotFoundException e){
            throw new FileNotFoundException("Filen ble ikke funnet!");
        }

        return utTekst;

    }
}

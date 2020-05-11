package Hjelpeklasser;

import Fxml.AdminSideController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javax.swing.*;

public class AdminInnlegging {

    private SimpleStringProperty navn;
    private SimpleStringProperty email;
    private SimpleStringProperty typebil;
    private SimpleStringProperty interior;
    private SimpleStringProperty farge;
    private SimpleIntegerProperty felger;
    private SimpleIntegerProperty pris;
    private SimpleIntegerProperty hestekrefter;


    //regex:
    String numberRegex = "(.)*(\\d)(.)*";  //For å sjekke om navnet inneholder numre.
    String emailRegex = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b"; //for å teste gyldighet på email.
    AdminSideController adminSideController = new AdminSideController();
    final JPanel panel = new JPanel();
    //Feilmeldinger
    Exceptions exceptions = new Exceptions("");

    public AdminInnlegging(String navn, String email, String typebil, int hestekrefter, String interior, String farge, int felger, int pris){

        this.navn = new SimpleStringProperty(navn);
        this.email = new SimpleStringProperty(email);
        this.typebil = new SimpleStringProperty(typebil);
        this.interior = new SimpleStringProperty(interior);
        this.farge = new SimpleStringProperty(farge);
        this.felger = new SimpleIntegerProperty(felger);
        this.pris = new SimpleIntegerProperty(pris);
        this.hestekrefter = new SimpleIntegerProperty(hestekrefter);

    }

    AdminSideController controller = new AdminSideController();


    // Tester riktig input fra admin.

    public String navn(String navn){

       if (navn.matches(numberRegex)){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Warning");
           alert.setHeaderText("Det ser ut som at det var en feil!");
           alert.setContentText("Navn er feil! Kan ikke inneholde nummer!");
           alert.showAndWait();
           exceptions.wrongInputException("Navn kan ikke inneholde nummer!");

        }else{
            this.navn = new SimpleStringProperty(navn);
        }
       return navn;
    }

    public String email(String email){
        //tester om input er riktig.
        if (email.matches(emailRegex)){
            this.email = new SimpleStringProperty(email);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Det ser ut som at det var en feil!");
            alert.setContentText("email er feil!");
            alert.showAndWait();
            exceptions.wrongInputException("Feil i emailadressen!");

        }
        return email;

    }
    public String typebil(String bil){
        //Tester om bil er riktig.
        if (bil.equals("el") || bil.equals("bensin") || bil.equals("diesel") || bil.equals("elbil"))
            this.typebil = new SimpleStringProperty(bil);

        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Det ser ut som at det var en feil!");
            alert.setContentText("typebil er feil!");
            alert.showAndWait();
            exceptions.wrongInputException("Feil type bil!");
        }

        return bil;
    }
    public Integer hestekrefter(int hestekrefter){
        // tester om hestekrefter er riktig
            if (hestekrefter>99 && hestekrefter<1000)
            this.hestekrefter = new SimpleIntegerProperty(hestekrefter);

            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText("Det ser ut som at det var en feil!");
                alert.setContentText("hestekrefter er feil!");
                alert.showAndWait();
                exceptions.wrongInputException("feil hestekrefter!");
            }
        return hestekrefter;
    }
    public String farge(String farge){
        // tester farge input
        if (farge.equals("hvit") || farge.equals("svart") || farge.equals("bronse") || farge.equals("rød"))
        this.farge = new SimpleStringProperty(farge);

        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Det ser ut som at det var en feil!");
            alert.setContentText("Farge er feil!");
            alert.showAndWait();
            exceptions.wrongInputException("feil farge!");
        }
        return farge;
    }
    public String interior(String interior) {

        // tester interiør input

        if (interior.equals("standard") || interior.equals("sport") || interior.equals("supreme"))
        this.interior = new SimpleStringProperty(interior);

        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Det ser ut som at det var en feil!");
            alert.setContentText("interior er feil!");
            alert.showAndWait();
            exceptions.wrongInputException("feil interior!");
        }

        return interior;
    }
    public Integer felger(int felger){

        // sjekker felger input

        if (felger>19 && felger<26)
        this.felger = new SimpleIntegerProperty(felger);

        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Det ser ut som at det var en feil!");
            alert.setContentText("feilger er feil!");
            alert.showAndWait();
            exceptions.wrongInputException("feil felger!");
        }
        return felger;
    }
    public Integer pris(int pris){
        // tester pris input

        this.pris = new SimpleIntegerProperty(pris);

        return pris;
    }

    // get-set metoder for

    public String getNavn(){
        return navn.getValue();
    }

    public void setNavn(String navn){
        this.navn.set(navn);
    }
    public String getEmail(){
        return email.getValue();
    }

    public void setEmail(String email){
        this.email.set(email);
    }

    public String getTypebil() {

        return typebil.getValue().toLowerCase();
    }

    public void setTypebil(String typebil) {
        this.typebil.set(typebil);

    }

    public Integer getHestekrefter() {
        return hestekrefter.getValue();
    }

    public void setHestekrefter(int hestekrefter) {
        this.hestekrefter.set(hestekrefter);

    }
    public String getInterior() {
        return interior.getValue().toLowerCase();
    }

    public void setInterior(String interior) {
        this.interior.set(interior);

    }
    public Integer getFelger() {
        return felger.getValue();
    }

    public void setFelger(int felger) {
        this.felger.set(felger);

    }
    public String getFarge() {
        return farge.getValue().toLowerCase();
    }

    public void setFarge(String farge) {
        this.farge.set(farge);

    }
    public Integer getPris() {
        return pris.getValue();
    }

    public void setPris(int pris) {
        this.pris.set(pris);
    }


}

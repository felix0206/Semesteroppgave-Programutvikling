package Hjelpeklasser;

import javafx.beans.property.SimpleStringProperty;

import javax.swing.*;

public class AdminInnlegging {

    private SimpleStringProperty navn;
    private SimpleStringProperty email;
    private SimpleStringProperty typebil;
    private SimpleStringProperty interior;
    private SimpleStringProperty farge;
    private SimpleStringProperty felger;
    private SimpleStringProperty pris;
    private SimpleStringProperty hestekrefter;


    //regex:
    String numberRegex = "(.)*(\\d)(.)*";  //For å sjekke om navnet inneholder numre.
    String emailRegex = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b"; //for å teste gyldighet på email.

    //Feilmeldinger
    Exceptions exceptions = new Exceptions("");

    public AdminInnlegging(String navn, String email, String typebil, String hestekrefter, String interior, String farge, String felger, String pris){

        this.navn = new SimpleStringProperty(navn);
        this.email = new SimpleStringProperty(email);
        this.typebil = new SimpleStringProperty(typebil);
        this.interior = new SimpleStringProperty(interior);
        this.farge = new SimpleStringProperty(farge);
        this.felger = new SimpleStringProperty(felger);
        this.pris = new SimpleStringProperty(pris);
        this.hestekrefter = new SimpleStringProperty(hestekrefter);

    }

    //TODO: if settninger for å kontrollere riktig input fra admin.

    public String navn(String navn){

       if (navn.matches(numberRegex)){
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
            exceptions.wrongInputException("Feil i emailadressen!");
        }
        return email;

    }
    public String typebil(String bil){
        //Tester om bil er riktig.
        if (bil.equals("el") || bil.equals("bensin") || bil.equals("diesel") || bil.equals("elbil"))
            this.typebil = new SimpleStringProperty(bil);

        else{
            exceptions.wrongInputException("Feil type bil!");
        }

        return bil;
    }
    public String hestekrefter(String hestekrefter){
            if (hestekrefter.equals("150") || hestekrefter.equals("200") || hestekrefter.equals("300"))
            this.hestekrefter = new SimpleStringProperty(hestekrefter);

            else{
                exceptions.wrongInputException("feil hestekrefter!");
            }
        return hestekrefter;
    }
    public String farge(String farge){
        if (farge.equals("hvit") || farge.equals("svart") || farge.equals("bronse") || farge.equals("rød"))
        this.farge = new SimpleStringProperty(farge);

        else{
            exceptions.wrongInputException("feil farge!");
        }
        return farge;
    }
    public String interior(String interior){

        if (interior.equals("standard") || interior.equals("sport") || interior.equals("supreme"))
        this.interior = new SimpleStringProperty(interior);

        else{
            exceptions.wrongInputException("feil interior!");
        }

        return interior;
    }
    public String felger(String felger){

        if (felger.equals("18") || felger.equals("20") || felger.equals("24"))
        this.felger = new SimpleStringProperty(felger);

        else{
            exceptions.wrongInputException("feil felger!");
        }
        return felger;
    }
    public String pris(String pris){

        this.pris = new SimpleStringProperty(pris);

        return pris;
    }

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

    public String getHestekrefter() {
        return hestekrefter.getValue();
    }

    public void setHestekrefter(String hestekrefter) {
        this.hestekrefter.set(hestekrefter);

    }
    public String getInterior() {
        return interior.getValue().toLowerCase();
    }

    public void setInterior(String interior) {
        this.typebil.set(interior);

    }
    public String getFelger() {
        return felger.getValue().toLowerCase();
    }

    public void setFelger(String felger) {
        this.typebil.set(felger);

    }
    public String getFarge() {
        return farge.getValue().toLowerCase();
    }

    public void setFarge(String farge) {
        this.typebil.set(farge);

    }
    public String getPris() {
        return pris.getValue();
    }

    public void setPris(String pris) {
        this.typebil.set(pris);
    }


}

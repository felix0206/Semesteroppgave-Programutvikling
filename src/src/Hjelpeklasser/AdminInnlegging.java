package Hjelpeklasser;

import javafx.beans.property.SimpleStringProperty;

import javax.swing.*;

public class AdminInnlegging {

    public SimpleStringProperty navn;
    public SimpleStringProperty email;
    public SimpleStringProperty typebil;
    public SimpleStringProperty interior;
    public SimpleStringProperty farge;
    public SimpleStringProperty felger;
    public SimpleStringProperty pris;
    public SimpleStringProperty hestekrefter;


    //regex:
    String numberRegex = "(.)*(\\d)(.)*";  //For å sjekke om navnet inneholder numre.
    String emailRegex = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b"; //for å teste gyldighet på email.


    public AdminInnlegging( String typebil, String hestekrefter, String interior, String farge, String felger, String pris){

        //this.navn = new SimpleStringProperty(navn);
        //this.navn = new SimpleStringProperty(email);
        this.typebil = new SimpleStringProperty(typebil);
        this.interior = new SimpleStringProperty(interior);
        this.farge = new SimpleStringProperty(farge);
        this.felger = new SimpleStringProperty(felger);
        this.pris = new SimpleStringProperty(pris);
        this.hestekrefter = new SimpleStringProperty(hestekrefter);

    }

    //Feilmeldinger
    Exceptions exceptions = new Exceptions("");

    //TODO: if settninger for å kontrollere riktig input fra admin.

    public String navn(String navn){

        if (navn.matches(numberRegex)){
            JOptionPane.showMessageDialog(null,exceptions.wrongInputException("Navn kan ikke inneholde nummer!"));
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
            System.out.println(exceptions.wrongInputException("Feil i emailadressen!"));
        }
        return email;

    }
    public String typebil(String bil){

        //tester om input er riktig.
        if (bil.toLowerCase().equals("el") || bil.toLowerCase().equals("elbil")
                || bil.toLowerCase().equals("diesel") || bil.toLowerCase().equals("bensin")){
            this.typebil = new SimpleStringProperty(bil);
        }else{
            System.out.println(exceptions.wrongInputException("ugyldig type bil!"));  //feilmelding
        }

        return bil;
    }
    public String hestekrefter(String hestekrefter){

        this.hestekrefter = new SimpleStringProperty(hestekrefter);

        return hestekrefter;
    }
    public String farge(String farge){

        this.farge = new SimpleStringProperty(farge);

        return farge;
    }
    public String interior(String interior){

        this.interior = new SimpleStringProperty(interior);

        return interior;
    }
    public String felger(String felger){

        this.felger = new SimpleStringProperty(felger);

        return felger;
    }
    public String pris(String pris){

        this.pris = new SimpleStringProperty(pris);

        return pris;
    }

   /* public String getNavn(){
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
    }*/

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

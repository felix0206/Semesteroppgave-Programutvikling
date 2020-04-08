package Hjelpeklasser;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AdminInnlegging {

    public SimpleStringProperty typebil;
    public SimpleStringProperty interior;
    public SimpleStringProperty farge;
    public SimpleStringProperty felger;
    public SimpleIntegerProperty pris;
    public SimpleIntegerProperty hestekrefter;



    public AdminInnlegging(String typebil, int hestekrefter, String interior, String farge, String felger, int pris){

        this.typebil = new SimpleStringProperty(typebil);
        this.interior = new SimpleStringProperty(interior);
        this.farge = new SimpleStringProperty(farge);
        this.felger = new SimpleStringProperty(felger);
        this.pris = new SimpleIntegerProperty(pris);
        this.hestekrefter = new SimpleIntegerProperty(hestekrefter);

    }

    public String typebil(String bil){

        this.typebil = new SimpleStringProperty(bil);

        return bil;
    }
    public int hestekrefter(int hestekrefter){

        this.hestekrefter = new SimpleIntegerProperty(hestekrefter);

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
    public int pris(int pris){

        this.pris = new SimpleIntegerProperty(pris);

        return pris;
    }

    public String getTypebil() {
        return typebil.getValue();
    }

    public void setTypebil(String typebil) {
        this.typebil.set(typebil);

    }

    public int getHestekrefter() {
        return hestekrefter.getValue();
    }

    public void setHestekrefter(int hestekrefter) {
        this.hestekrefter.set(hestekrefter);

    }
    public String getInterior() {
        return interior.getValue();
    }

    public void setInterior(String interior) {
        this.typebil.set(interior);

    }
    public String getFelger() {
        return felger.getValue();
    }

    public void setFelger(String felger) {
        this.typebil.set(felger);

    }
    public String getFarge() {
        return farge.getValue();
    }

    public void setFarge(String farge) {
        this.typebil.set(farge);

    }
    public int getPris() {
        return pris.getValue();
    }

    public void setPris(String pris) {
        this.typebil.set(pris);

    }


}

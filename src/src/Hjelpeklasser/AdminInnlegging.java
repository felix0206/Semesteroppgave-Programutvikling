package Hjelpeklasser;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AdminInnlegging {

    public SimpleStringProperty typebil;
    public SimpleStringProperty interior;
    public SimpleStringProperty farge;
    public SimpleStringProperty felger;
    public SimpleStringProperty pris;
    public SimpleStringProperty hestekrefter;

    public String getTypebil() {
        return typebil.get();
    }

    public SimpleStringProperty typebilProperty() {
        return typebil;
    }

    public void setTypebil(String typebil) {
        this.typebil.set(typebil);
    }

    public String getInterior() {
        return interior.get();
    }

    public SimpleStringProperty interiorProperty() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior.set(interior);
    }

    public String getFarge() {
        return farge.get();
    }

    public SimpleStringProperty fargeProperty() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge.set(farge);
    }

    public String getFelger() {
        return felger.get();
    }

    public SimpleStringProperty felgerProperty() {
        return felger;
    }

    public void setFelger(String felger) {
        this.felger.set(felger);
    }

    public String getPris() {
        return pris.get();
    }

    public SimpleStringProperty prisProperty() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris.set(pris);
    }

    public String getHestekrefter() {
        return hestekrefter.get();
    }

    public SimpleStringProperty hestekrefterProperty() {
        return hestekrefter;
    }

    public void setHestekrefter(String hestekrefter) {
        this.hestekrefter.set(hestekrefter);
    }

    public AdminInnlegging(String typebil, String hestekrefter, String interior, String farge, String felger, String pris){

        this.typebil = new SimpleStringProperty(typebil);
        this.interior = new SimpleStringProperty(interior);
        this.farge = new SimpleStringProperty(farge);
        this.felger = new SimpleStringProperty(felger);
        this.pris = new SimpleStringProperty(pris);
        this.hestekrefter = new SimpleStringProperty(hestekrefter);

    }

}

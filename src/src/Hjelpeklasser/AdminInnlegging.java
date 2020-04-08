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

    public int getPris() {
        return pris.get();
    }

    public SimpleIntegerProperty prisProperty() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris.set(pris);
    }

    public int getHestekrefter() {
        return hestekrefter.get();
    }

    public SimpleIntegerProperty hestekrefterProperty() {
        return hestekrefter;
    }

    public void setHestekrefter(int hestekrefter) {
        this.hestekrefter.set(hestekrefter);
    }

    public AdminInnlegging(String typebil, int hestekrefter, String interior, String farge, String felger, int pris){

        this.typebil = new SimpleStringProperty(typebil);
        this.interior = new SimpleStringProperty(interior);
        this.farge = new SimpleStringProperty(farge);
        this.felger = new SimpleStringProperty(felger);
        this.pris = new SimpleIntegerProperty(pris);
        this.hestekrefter = new SimpleIntegerProperty(hestekrefter);

    }

    public void typebil(String typebilText) {
    }
}

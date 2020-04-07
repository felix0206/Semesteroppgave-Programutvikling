package Hjelpeklasser;

import javafx.beans.property.SimpleStringProperty;

public class KundeModell{

    public SimpleStringProperty fornavn;
    public SimpleStringProperty etternavn;
    public SimpleStringProperty epost;


    public String getFornavn() {
        return fornavn.get();
    }

    public SimpleStringProperty fornavnProperty() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
    }

    public String getEtternavn() {
        return etternavn.get();
    }

    public SimpleStringProperty etternavnProperty() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn.set(etternavn);
    }

    public String getEpost() {
        return epost.get();
    }

    public SimpleStringProperty epostProperty() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost.set(epost);
    }

    public KundeModell(String fornavn, String etternavn, String epost){

        this.fornavn = new SimpleStringProperty(fornavn);
        this.etternavn = new SimpleStringProperty(etternavn);
        this.epost = new SimpleStringProperty(epost);

    }

}

package Hjelpeklasser;

public class PrisKalkulator {

    String typebil;
    String farge;
    String felger;
    String interior;
    String hestekrefter;
    int pristeller;


    public PrisKalkulator(String typebil, String farge, String felger, String interior, String hestekrefter) {
        this.typebil = typebil;
        this.farge = farge;
        this.felger = felger;
        this.interior = interior;
        this.hestekrefter = hestekrefter;
    }

    public void typebilPrisKalk() {
        if (typebil.equals("elbil"))
            pristeller += 200000;

        if (typebil.equals("bensin"))
            pristeller += 250000;

        if (typebil.equals("diesel"))
            pristeller += 300000;
    }

    public void fargePrisKalk() {
        if (farge.equals("hvit") || farge.equals("svart")
                || farge.equals("rød"))
            pristeller += 15000;
        if (farge.equals("bronse"))
            pristeller += 22000;
    }

    public void felgePrisKalk() {
        if (felger.equals("18 tommer"))
            pristeller += 12000;
        if (felger.equals("20 tommer"))
            pristeller += 16000;
        if (felger.equals("24 tommer"))
            pristeller += 19000;
    }

    public void hesterPrisKalk(){
        if (hestekrefter.equals("150hk"))
            pristeller+=50000;
        if (hestekrefter.equals("200hk"))
            pristeller+=100000;
        if (hestekrefter.equals("300hk"))
            pristeller+=150000;
    }

    public void interiorPrisKalk(){
        if (interior.equals("standard"))
            pristeller+=10000;
        if (interior.equals("sport"))
            pristeller+=25000;
        if (interior.equals("supreme"))
            pristeller+=40000;
    }

    public String getPris(){
        String sistePris = Integer.toString(pristeller);
        return sistePris;
    }
}
package Hjelpeklasser;

import Fxml.AdminSideController;

public class Reset {
    AdminSideController admin = new AdminSideController();
    public void resetNavn(){
        admin.navn.setText("");
        admin.navn.setPromptText("<< ugyldig navn >>");
    }
    public void resetEmail(){
        admin.email.setText("");
        admin.email.setPromptText("<< ugyldig email >>");
    }
    public void resetTypeBil(){
        admin.typebil.setText("");
        admin.typebil.setPromptText("<< elbil, bensin, diesel >>");
    }
    public void resetHestekrefter(){
        admin.hestekrefter.setText("");
        admin.hestekrefter.setPromptText("<< 100-1000 >>");
    }
    public void resetInterior(){
        admin.interior.setText("");
        admin.interior.setPromptText("<< standard, sport, supreme >>");
    }
    public void resetFarge(){
        admin.farge.setText("");
        admin.farge.setPromptText("<< hvit, svart, rød, bronse >>");
    }
    public void resetFelger(){
        admin.felger.setText("");
        admin.felger.setPromptText("<<20-25>>");
    }
}

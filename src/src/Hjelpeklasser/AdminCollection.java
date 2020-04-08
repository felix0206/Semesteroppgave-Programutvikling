package Hjelpeklasser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


public class AdminCollection {
    private ObservableList<AdminInnlegging> liste = FXCollections.observableArrayList();

    public void setTable(TableView tv){
        tv.setItems(liste);
    }

    public void leggtil(AdminInnlegging obj){
        liste.add(obj);
    }
}

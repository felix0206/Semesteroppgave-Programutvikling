package Hjelpeklasser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;



public class AdminCollection  {
    public ObservableList<AdminInnlegging> liste = FXCollections.observableArrayList();

    public void setTable(TableView tv){
        tv.setItems(liste);
    }

    public void leggtil(AdminInnlegging obj){
        liste.add(obj);
    }

    public void filtrer(){
        FilteredList<AdminInnlegging> filter = new FilteredList<>(liste, b -> true);
    }
}

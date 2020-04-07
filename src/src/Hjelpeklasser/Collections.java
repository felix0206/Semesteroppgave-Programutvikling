package Hjelpeklasser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Collections {

    private ObservableList<KundeModell> list = FXCollections.observableArrayList();

    public void attachTableView(TableView tv) {
        tv.setItems(list);
    }

    public void addElement(KundeModell obj) {
        list.add(obj);
    }

}

package sample.Application.ObservLists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Databases.InMemoryBoxDB;

public class ObservBoxList {

    private InMemoryBoxDB boxDB = new InMemoryBoxDB();


    public ObservableList getData(){
        ObservableList data = FXCollections.observableArrayList(boxDB.getBox());
        return data;
    }
}

package sample.Application.ObservLists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Databases.InMemoryDiscsDB;

public class ObservDiscList {

    private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();


    public ObservableList getData(){
        ObservableList data = FXCollections.observableArrayList(discsDB.getDiscs());
        return data;
    }
}

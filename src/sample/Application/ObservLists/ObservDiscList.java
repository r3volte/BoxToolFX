package sample.Application.ObservLists;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Databases.InMemoryDiscsDB;

public class ObservDiscList implements InMemoryDiscsDB {

    public ObservableList getData(){
        ObservableList data = FXCollections.observableArrayList(discs);
        return data;
    }
}

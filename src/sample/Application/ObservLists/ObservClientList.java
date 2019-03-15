package sample.Application.ObservLists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Databases.InMemoryClientsDB;

public class ObservClientList {

    private InMemoryClientsDB clientsDB = new InMemoryClientsDB();


    public ObservableList getData(){
        ObservableList data = FXCollections.observableArrayList(clientsDB.getClients());
        return data;
    }
}

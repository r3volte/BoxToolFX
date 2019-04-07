package sample.Application.ObservLists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Databases.InMemoryClientsDB;

public class ObClientList {

  private InMemoryClientsDB clientsDB = new InMemoryClientsDB();


  public ObservableList getData() {
    return FXCollections.observableArrayList(clientsDB.getClients());
  }
}

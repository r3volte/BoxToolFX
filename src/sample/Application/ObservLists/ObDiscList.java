package sample.Application.ObservLists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Databases.InMemoryDiscsDB;


public class ObDiscList implements ObList {

  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();


  public ObservableList getData() {
    return FXCollections.observableArrayList(discsDB.getDiscs());
  }

}

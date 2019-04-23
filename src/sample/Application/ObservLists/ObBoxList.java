package sample.Application.ObservLists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Databases.InMemoryBoxDB;

public class ObBoxList implements ObList {

  private InMemoryBoxDB boxDB = new InMemoryBoxDB();


  public ObservableList getData() {
    return FXCollections.observableArrayList(boxDB.getBox());
  }
}

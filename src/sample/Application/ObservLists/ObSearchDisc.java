package sample.Application.ObservLists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Data.Box;
import sample.Application.Data.Discs;

import java.util.List;

public class ObSearchDisc {

  public ObservableList getDataDisc(List<Discs> list) {
    return FXCollections.observableArrayList(list);
  }
  public ObservableList getDataBox(List<Box> list) {
    return FXCollections.observableArrayList(list);
  }
}

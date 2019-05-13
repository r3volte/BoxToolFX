package sample.Application.ObservLists;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Data.Box;
import sample.Application.Data.Discs;


public class ObSearchDisc {

  public ObservableList getDataDisc(List<Discs> list) {
    return FXCollections.observableArrayList(list);
  }

  public ObservableList getDataBox(List<Box> list) {
    return FXCollections.observableArrayList(list);
  }
}

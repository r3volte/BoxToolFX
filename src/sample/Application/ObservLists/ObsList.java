package sample.Application.ObservLists;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Application.Databases.InMemoryBoxDB;
import sample.Application.Databases.InMemoryRepo;

import java.util.List;

public class ObsList {

  private InMemoryRepo repo;

  public ObsList(InMemoryRepo repo) {
    this.repo = repo;
  }

  public InMemoryRepo getRepo() {
    return repo;
  }

  public ObservableList getData(List list) {
    return FXCollections.observableArrayList(list);
  }
}

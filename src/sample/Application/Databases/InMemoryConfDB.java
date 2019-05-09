package sample.Application.Databases;

import java.util.ArrayList;
import java.util.List;

import sample.Application.Data.Configurations;


public class InMemoryConfDB {

  private static List<List<Configurations>> conf = new ArrayList<>();

  public List<List<Configurations>> getConf() {
    return conf;
  }

  public void addOtherLists(List<Configurations> list) {
    getConf().add(list);
  }
}

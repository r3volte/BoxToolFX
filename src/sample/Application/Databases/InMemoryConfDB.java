package sample.Application.Databases;

import java.util.ArrayList;
import java.util.List;

import sample.Application.Data.Configurations;


public class InMemoryConfDB {

  private static List<Configurations> conf = new ArrayList<>();

  public List<Configurations> getConf() {
    return conf;
  }
}

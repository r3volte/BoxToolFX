package sample.Application.Databases.Configurations;

import sample.Application.Data.Configurations;

import java.util.ArrayList;
import java.util.List;


public class NKBoxDatabase {

  private static List<Configurations> nkBoxes = new ArrayList<>();

  public List<Configurations> getNKBoxes() {
    return nkBoxes;
  }
}

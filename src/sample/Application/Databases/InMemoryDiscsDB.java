package sample.Application.Databases;

import java.util.ArrayList;
import java.util.List;

import sample.Application.Data.Discs;


public class InMemoryDiscsDB implements InMemoryDB {

  private static List<Discs> discs = new ArrayList<>();

  public List<Discs> getDiscs() {
    return discs;
  }

  @Override
  public void showDB() {
    discs.stream().map(x -> x.toString())
                  .forEach(x -> System.out.println(x));
  }

}

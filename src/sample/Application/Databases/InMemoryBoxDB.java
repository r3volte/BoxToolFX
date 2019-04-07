package sample.Application.Databases;

import java.util.ArrayList;
import java.util.List;

import sample.Application.Data.Box;


public class InMemoryBoxDB implements InMemoryDB {

  private static List<Box> box = new ArrayList<>();

  public List<Box> getBox() {
    return box;
  }

  @Override
  public void showDB() {
    box.stream().map(x -> x.toString())
            .forEach(x -> System.out.println(x));
  }
}

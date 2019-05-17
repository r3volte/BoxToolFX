package sample.Application.Databases;

import java.util.ArrayList;
import java.util.List;

import sample.Application.Data.Box;


public class InMemoryBoxDB extends InMemoryDB {

  private static List<Box> box = new ArrayList<>();

  public List<Box> getBox() {
    return box;
  }


  @Override
  public void showDB() {
    box.stream().map(Box::toString)
            .forEach(System.out::println);
  }
}

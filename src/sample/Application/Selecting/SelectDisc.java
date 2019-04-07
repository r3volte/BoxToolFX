package sample.Application.Selecting;

import lombok.Getter;
import sample.Application.Data.Box;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryBoxDB;
import sample.Application.Databases.InMemoryDiscsDB;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SelectDisc {


  private Scanner scanner = new Scanner(System.in);


  public void selector() {
    System.out.println("Enter data: ");
    int numGiven = scanner.nextInt();
    System.out.println("Disc dumber: " + numGiven);
    InMemoryDiscsDB discsDB = new InMemoryDiscsDB();
    System.out.println(searchDisc(discsDB.getDiscs(), numGiven).toString());
  }

  private List<Discs> searchDisc(final List<Discs> list, final int number) {
    return  list.stream().filter(discs -> discs.getNumber() == number).collect(Collectors.toList());
  }
}

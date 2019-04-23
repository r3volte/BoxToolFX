package sample.Application.Selecting;


import sample.Application.Data.Discs;
import java.util.List;
import java.util.stream.Collectors;

public class SelectDisc {


  public List<Discs> searchDisc(final List<Discs> list, final int number) {
    return list.stream().filter(discs -> discs
            .getNumber() == number)
            .collect(Collectors.toList());
  }
}

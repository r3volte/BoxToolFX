package sample.Application.Selecting;

import java.util.List;
import java.util.stream.Collectors;
import sample.Application.Data.Discs;


public class SelectDisc {


  public List<Discs> searchDisc(final List<Discs> list, final int number) {
    return list.stream().filter(discs -> discs
            .getNumber() == number)
            .collect(Collectors.toList());
  }
}

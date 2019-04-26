package sample.Application.Selecting;

import sample.Application.Data.Box;
import sample.Application.Data.Discs;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BoxSelector {


  public void selectBox(List<Discs> dLst, List<Box> bList) {

    //Predicate<Discs> isWeight = is -> is.getWeight() > 9.5;
    Predicate<Box> discsPredicate = x -> x.getWidth() < dLst.listIterator().next().getDiameter()
            && x.getHeight() < dLst.iterator().next().getHeight2();
    System.out.println(bList.stream().filter(discsPredicate).map(e -> e.getNumber()).collect(Collectors.toList()).toString());
  }
}

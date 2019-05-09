package sample.Application.Selecting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import sample.Application.Data.Box;
import sample.Application.Data.Discs;

public class BoxSelector {


  public List<Box> selectBox(List<Discs> discsList, List<Box> boxList) {
    final List<Box> list = new ArrayList<>();
    discsList.forEach(i -> {
      if (i.getWeight() > 9.5) {
        Predicate<Box> discsPredicate = x ->
                x.getWidth() >= discsList.listIterator().next().getDiameter()
                        && x.getHeight() > discsList.iterator().next().getHeight();
        Optional<Box> singleDisc = boxList.stream().filter(discsPredicate).findFirst();
        list.addAll(singleDisc.map(Collections::singletonList)
                .orElseGet(Collections::emptyList));
        System.out.println(list);
      } else {
        Predicate<Box> discsPredicatex2 = x ->
                x.getWidth() >= discsList.listIterator().next().getDiameter()
                        && x.getHeight() > discsList.iterator().next().getHeight2();
        Optional<Box> multiDiscs = boxList.stream().filter(discsPredicatex2).findFirst();
        list.addAll(multiDiscs.map(Collections::singletonList)
                .orElseGet(Collections::emptyList));
        System.out.println(list);
      }
    });
    return list;
  }
}

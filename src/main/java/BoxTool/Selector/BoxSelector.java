package boxTool.selector;

import boxTool.data.Box;
import boxTool.data.Discs;
import boxTool.databaseOperations.ListType;
import boxTool.fileResources.Resources;
import com.google.gson.Gson;
import javafx.scene.control.TextArea;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Logger;

@Component
public class BoxSelector {

  private final Logger logger = Logger.getLogger(this.getClass().getName());
  private final String RES_ONE = "Disc is packed single";
  private final String RES_TWO = "Disc is packed double";


  public List<Box> selectBox(List<Discs> discsList, List<Box> boxList, TextArea result) {
    final List<Box> list = new ArrayList<>();
    final List neuSingleBox = new ArrayList<>();
    final List neuDoubleBox = new ArrayList<>();
    discsList.forEach(i -> {
      if (i.getWeight() > 9.5 || i.getHeight2() > 179) {
        try {
          neuSingleBox.addAll(singleDisc(neutralBoxList(), singleDiscPre(discsList))
                  .map(Collections::singletonList).orElse(Collections.EMPTY_LIST));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        list.addAll(singleDisc(boxList, singleDiscPre(discsList))
                .map(Collections::singletonList)
                .orElse(neuSingleBox));
        logger.info(String.valueOf(list));
        result.appendText(RES_ONE + "\n");
      } else {
        try {
          neuSingleBox.addAll(doubleDisc(neutralBoxList(), doubleDiscPre(discsList))
                  .map(Collections::singletonList).orElse(Collections.EMPTY_LIST));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        list.addAll(doubleDisc(boxList, doubleDiscPre(discsList)).map(Collections::singletonList)
                .orElse(neuDoubleBox));
        result.appendText(RES_TWO + "\n");
        logger.info(String.valueOf(list));
      }
    });
    return list;
  }

  private Predicate<Box> singleDiscPre(List<Discs> discsList) {
    return x ->
            x.getWidth() >= discsList.listIterator().next().getDiameter()
                    && x.getHeight() > discsList.iterator().next().getHeight();
  }

  private Optional<Box> singleDisc(List<Box> boxList, Predicate<Box> predicate) {
    return boxList.stream().filter(predicate).findFirst();
  }

  private Predicate<Box> doubleDiscPre(List<Discs> discsList) {
    return x ->
            x.getWidth() >= discsList.listIterator().next().getDiameter()
                    && x.getHeight() > discsList.iterator().next().getHeight2();
  }


  private Optional<Box> doubleDisc(List<Box> boxList, Predicate<Box> predicate) {
    return boxList.stream().filter(predicate).findFirst();
  }

  public List<Box> neutralBoxList() throws FileNotFoundException {
    List<Box> list = new ArrayList<>();
    ArrayList tempList = new Gson().fromJson(new FileReader(Resources.neuDB()), ListType.listBox());
    list.addAll(tempList);
    return list;
  }
}

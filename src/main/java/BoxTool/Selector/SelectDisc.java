package BoxTool.Selector;

import BoxTool.Data.Discs;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class SelectDisc {

  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public List<Discs> searchDisc(final List<Discs> list, final Integer number) {
    List<Discs> temp = list.stream().filter(discs -> discs
            .getNumber().equals(number))
            .collect(Collectors.toList());
    if (temp.isEmpty()) {
      logger.warning("Input number not found in database, please try again");
      return null;
    }
    return temp;
  }
}

package BoxTool.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Discs {

  private Integer number;
  private final Double diameter;
  private final Double height;
  private final Double height2;
  private final Double weight;

}

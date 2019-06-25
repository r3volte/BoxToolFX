package boxTool.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clients {

  private Integer id;
  private String name;
  private String discConf;
  private String discPcsPerBox;
  private String coatedConf;
  private String coatedPcsPerBox;
  private String drumConf;
  private String drumPcsPerBox;
  private String montInst;

}

package BoxTool.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clients {

  private Integer id;
  private String name;
  private String discConf;
  private PcsPerBox discPcsPerBox;
  private String coatedConf;
  private PcsPerBox coatedPcsPerBox;
  private String drumConf;
  private PcsPerBox drumPcsPerBox;
  private MountInstruction montInst;

}

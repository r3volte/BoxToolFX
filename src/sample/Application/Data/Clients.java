package sample.Application.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
public class Clients {

  private final int id;
  private final String name;
  private final String discConf;
  private final PcsPerBox discPcsPerBox;
  private final String coatedConf;
  private final PcsPerBox coatedPcsPerBox;
  private final String drumConf;
  private final PcsPerBox drumPcsPerBox;
  private final MountInstruction montInst;
}

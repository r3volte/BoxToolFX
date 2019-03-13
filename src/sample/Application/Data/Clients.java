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
    private final int discPcsPerBox;
    private final String coatedConf;
    private final int coatedPcsPerBox;
    private final String drumConf;
    private final int drumPcsPerBox;
    private final String montInst;

}

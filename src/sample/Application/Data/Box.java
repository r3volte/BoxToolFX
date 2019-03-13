package sample.Application.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Box {

    //private final String name;
    private final int number;
    private final int width;
    private final int height;
}

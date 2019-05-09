package sample.Application.Data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Configurations {

  private String configurationName;
  private int number;
  private int height;
  private int width;

  public Configurations(String configurationName, int number, int height, int width) {
    this.configurationName = configurationName;
    this.number = number;
    this.height = height;
    this.width = width;
  }
}

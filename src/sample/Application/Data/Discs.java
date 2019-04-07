package sample.Application.Data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Discs {

  private final int number;
  private final double diameter;
  private final double height;
  private final double height2;
  private final double weight;

  /**
    Public constructor for discs data.
    Used for creating new index in discs database.
   */
  public Discs(int number, double diameter, double height, double height2, double weight) {
    this.number = number;
    this.diameter = diameter;
    this.height = height;
    this.height2 = height2;
    this.weight = weight;
  }
}
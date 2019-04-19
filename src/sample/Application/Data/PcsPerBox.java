package sample.Application.Data;

import com.google.gson.annotations.SerializedName;

public enum PcsPerBox {

  @SerializedName("0")
  ZERO(0),
  @SerializedName("1")
  ONE(1),
  @SerializedName("2")
  TWO(2);


  private final int value;

  PcsPerBox(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}

package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lombok.Getter;

public class SearchController {

  @FXML
  @Getter
  public JFXButton searchSubmit;
  public TextField numField;


  @FXML
  void initialize() {

    searchSubmit.addEventHandler(MouseEvent.MOUSE_CLICKED, search);
  }


  EventHandler<MouseEvent> search = ok -> {
    int number = Integer.parseInt(numField.getText());
    System.out.println(number);
  };
}

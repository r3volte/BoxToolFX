package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import sample.Application.Selecting.CheckConfSelector;


public class AddConfBoxController extends Controller {

  @FXML
  private JFXButton clearConfBoxButton;
  @FXML
  private JFXButton submitConfBoxButton;
  @FXML
  private TextField numConfBox;
  @FXML
  private CheckBox cb1;
  @FXML
  private CheckBox cb2;
  @FXML
  private CheckBox cb3;
  @FXML
  private CheckBox cb4;
  @FXML
  private CheckBox cb5;

  @FXML
  public StackPane rootPane;

  @Override
  @FXML
  void initialize() {
    clearConfBoxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
    submitConfBoxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
  }

  EventHandler<MouseEvent> clear = cl -> {
    numConfBox.clear();
  };

  EventHandler<MouseEvent> submitOk = ok -> {

      CheckConfSelector checkConfSelector = new CheckConfSelector();
      //checkConfSelector.adder(numConfBox, cb1, cb2, cb3, cb4, cb5);
  };

}

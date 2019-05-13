package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


public class AddConfBoxController extends Controller {

  @FXML
  private JFXButton clearConfBoxButton;
  @FXML
  private JFXButton submitConfBoxButton;
  @FXML
  private TextField numConfBox;
  @FXML
  public StackPane rootPane;

  @Override
  @FXML
  void initialize() {
    clearConfBoxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
    submitConfBoxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
  }

  EventHandler<MouseEvent> clear = cl ->  numConfBox.clear();

  EventHandler<MouseEvent> submitOk = ok -> {

  };

}

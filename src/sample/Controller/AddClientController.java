package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class AddClientController extends Controller {

  @FXML
  private StackPane clientPanel;
  @FXML
  private TextField numberField;
  @FXML
  private TextField idField;
  @FXML
  private JFXButton clientSumbitButt;
  @FXML
  private JFXButton clientClearButt;


  @Override
  @FXML
  void initialize() {
    clientClearButt.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
  }

  EventHandler<MouseEvent> clear = cl -> {
    idField.clear();
    numberField.clear();
  };
}

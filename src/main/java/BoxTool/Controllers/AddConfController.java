package BoxTool.Controllers;

import BoxTool.Services.DatabaseConfService;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddConfController {

  @FXML
  private JFXButton clearConfButton;
  @FXML
  private JFXButton submitConfButton;
  @FXML
  private TextField confName;
  @FXML
  private CheckComboBox<String> confList;
  @Autowired
  private DatabaseConfService databaseConfService;
  @Autowired
  private Controller controller;

  @FXML
  void initialize() {
    clearConfButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
  }

  private EventHandler<MouseEvent> clear = cl ->
          confName.clear();

}

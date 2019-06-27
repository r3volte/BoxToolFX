package boxTool.controllers;

import boxTool.services.DatabaseClientService;
import boxTool.ui.AddFrame;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddClientController {

  @FXML
  private JFXButton clientClearButt;
  @FXML
  private JFXButton clientSumbitButt;
  @FXML
  private TextField idField;
  @FXML
  private TextField nameField;
  @FXML
  private TextField drumConfField;
  @FXML
  private TextField discConfField;
  @FXML
  private TextField coatedConfField;
  @FXML
  private TextField montIns;
  @FXML
  private TextField discsPcs;
  @FXML
  private TextField coatedPcs;
  @FXML
  private TextField drumPcs;
  private DatabaseClientService databaseClientService;
  private AddFrame clientFrame;

  @Autowired
  public void setDatabaseClientService(DatabaseClientService databaseClientService) {
    this.databaseClientService = databaseClientService;
  }

  @Autowired
  public void setClientFrame(AddFrame boxFrame) {
    this.clientFrame = boxFrame;
  }

  @FXML
  void initialize() {
    clientClearButt.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
    clientSumbitButt.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
  }

  EventHandler<MouseEvent> clear = cl -> {
    idField.clear();
    nameField.clear();
    drumConfField.clear();
    discConfField.clear();
    coatedConfField.clear();
  };

  EventHandler<MouseEvent> submitOk = ok -> {
    try {
      databaseClientService.addNewClient(idField, nameField, discConfField,
              coatedConfField, drumConfField, montIns, discsPcs, coatedPcs, drumPcs);
    } catch (NumberFormatException e) {
      clientFrame.error();
    }
  };
}

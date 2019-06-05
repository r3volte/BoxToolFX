package BoxTool.Controllers;

import BoxTool.Services.DatabaseBoxService;
import BoxTool.UI.Frames.AddFrame;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddBoxController {

  @FXML
  private JFXButton clearBoxButton;
  @FXML
  private JFXButton submitBoxButton;
  @FXML
  private TextField numBox;
  @FXML
  private TextField boxWidth;
  @FXML
  private TextField boxHeight;

  private DatabaseBoxService databaseBoxService;
  @Autowired
  private AddFrame boxFrame;
  @Autowired
  private Controller controller;


  @Autowired
  public void setDatabaseBoxService(DatabaseBoxService databaseBoxService) {
    this.databaseBoxService = databaseBoxService;
  }

  @FXML
  void initialize() {
    clearBoxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
    submitBoxButton.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
  }

  EventHandler<MouseEvent> clear = cl -> {
    numBox.clear();
    boxWidth.clear();
    boxHeight.clear();
  };

  EventHandler<MouseEvent> submitOk = ok -> {
    try {
      databaseBoxService.addNewBox(numBox, boxWidth, boxHeight);
      databaseBoxService.refreshTable(controller);
    } catch (NumberFormatException e) {
      boxFrame.error();
    }
  };
}

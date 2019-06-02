package BoxTool.Controllers;

import BoxTool.Services.DatabaseBoxService;
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

//  public AddBoxController() {
//    System.out.println("empty!");
//  }

  @Autowired
  public AddBoxController(DatabaseBoxService databaseBoxService) {
    System.out.println("TEST");
    System.out.println(databaseBoxService);
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
      databaseBoxService.addNewBox();
    } catch (NumberFormatException e) {
//      AddFrame boxFrame = new BoxFrame();
//      boxFrame.error();
    }
  };
}

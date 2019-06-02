package BoxTool.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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
  void initialize() {
    clearConfButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
    submitConfButton.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
  }

  private EventHandler<MouseEvent> clear = cl ->
          confName.clear();

  private EventHandler<MouseEvent> submitOk = ok -> {
    String name = confName.getText();
    Tab tab = new Tab(name);
    System.out.println(name);
//    TableView newTable = new TableView();
//
//    TableColumn numTable = new TableColumn();
//    TableColumn wTable = new TableColumn();
//    TableColumn hTable = new TableColumn();
  };
}

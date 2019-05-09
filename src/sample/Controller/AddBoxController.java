package sample.Controller;

import com.jfoenix.controls.JFXButton;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import sample.Application.Data.Box;
import sample.Application.Databases.InMemoryBoxDB;
import sample.Controller.Events.BoxEvents.AddBoxAddEvent;
import sample.Controller.Events.BoxEvents.ErrorBoxEvents;

public class AddBoxController extends Controller {

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
  @FXML
  public StackPane rootPane;

  private Controller controller = new Controller();
  private static final Logger logger = Logger.getLogger(AddDiscController.class.getName());
  private InMemoryBoxDB inMemoryBoxDB = new InMemoryBoxDB();
  private ErrorBoxEvents error = new ErrorBoxEvents();
  private AddBoxAddEvent addBoxAddEvent = new AddBoxAddEvent();


  @Override
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
      Integer num = Integer.valueOf((numBox.getText()));
      int boxW = Integer.parseInt(boxWidth.getText());
      int boxH = Integer.parseInt(boxHeight.getText());
      inMemoryBoxDB.getBox().add(new Box(num, boxH, boxW));
      controller.getBoxTable();
      getBoxTable().refresh();
      addBoxAddEvent.closeWindows();
    } catch (NumberFormatException e) {
      error.error();
      logger.log(Level.FINE, "Brak danych, wpisz je jeszcze raz");
    }
  };

}

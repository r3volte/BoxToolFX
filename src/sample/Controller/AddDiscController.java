package sample.Controller;

import com.jfoenix.controls.JFXButton;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Controller.Events.DiscEvents.ErrorPanelEvents;
import sample.Controller.Events.ErrorEvent;

public class AddDiscController extends Controller {

  private static final Logger logger = Logger.getLogger(AddDiscController.class.getName());
  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();
  private Controller controller = new Controller();
  private ErrorEvent errorPanelEvents = new ErrorPanelEvents();

  @FXML
  private JFXButton clearButton;
  @FXML
  private JFXButton submitButton;
  @FXML
  private TextField numField;
  @FXML
  private TextField diaField;
  @FXML
  private TextField hField;
  @FXML
  private TextField wField;
  @FXML
  public StackPane rootPane;


  @Override
  @FXML
  void initialize() {
    clearButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
    submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
  }

  EventHandler<MouseEvent> clear = cl -> {
    numField.clear();
    diaField.clear();
    hField.clear();
    wField.clear();
  };

  EventHandler<MouseEvent> submitOk = ok -> {
    try {
      int number = Integer.parseInt(numField.getText());
      double diameter = Double.parseDouble(diaField.getText());
      double height = Double.parseDouble(hField.getText());
      double heightX2 = height * 2;
      double weight = Double.parseDouble(wField.getText());
      discsDB.getDiscs().add(new Discs(number, diameter, height, heightX2, weight));
      controller.getDiscTable();
      discsDB.showDB();
    } catch (NumberFormatException e) {
      errorPanelEvents.error();
      logger.log(Level.FINE, "Brak danych, wpisz je jeszcze raz");
    }
  };
}

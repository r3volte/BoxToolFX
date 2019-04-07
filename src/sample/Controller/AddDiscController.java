package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;

public class AddDiscController extends Controller {

  private static final Logger logger = Logger.getLogger(AddDiscController.class.getName());
  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();
  private Controller controller = new Controller();

  @FXML
  public JFXButton clearButton;
  public JFXButton submitButton;
  public TextField numField;
  public TextField diaField;
  public TextField hField;
  public TextField wField;
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
      controller.discTable.refresh();
      discsDB.showDB();
    } catch (NumberFormatException e) {
      JFXDialogLayout layout;
      layout = new JFXDialogLayout();
      layout.setStyle("-fx-background-color: #2A2E37;");
      Button oks = new Button("Okey");
      JFXDialog error = new JFXDialog(rootPane, layout, JFXDialog.DialogTransition.TOP);
      oks.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent c) ->
              error.close());
      layout.setBody(new Text("Please fill all fields with data, can't add new disc !!!"));
      layout.setActions(oks);
      error.show();
      logger.log(Level.FINE, "Brak danych, wpisz je jeszcze raz");
    }
  };
}

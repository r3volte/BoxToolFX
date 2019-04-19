package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import sample.Application.Data.Clients;
import sample.Application.Data.MountInstruction;
import sample.Application.Data.PcsPerBox;
import sample.Application.Databases.InMemoryClientsDB;

public class AddClientController extends Controller {

  private Controller controller = new Controller();
  private InMemoryClientsDB inMemoryClientsDB = new InMemoryClientsDB();
  @FXML
  private StackPane clientPanel;
  @FXML
  private TextField nameField;
  @FXML
  private TextField idField;
  @FXML
  private JFXButton clientSumbitButt;
  @FXML
  private JFXButton clientClearButt;
  @FXML
  private ChoiceBox discPcs;
  @FXML
  private ChoiceBox coatedPcs;
  @FXML
  private ChoiceBox drumsPcs;
  @FXML
  private ChoiceBox montIns;

  @Override
  @FXML
  void initialize() {
    setDiscPcs();
    clientClearButt.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
    //clientSumbitButt.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
  }

  EventHandler<MouseEvent> submitOk = ok -> {

    int number = Integer.parseInt(idField.getText());
    String name = nameField.getText();
    PcsPerBox ndPcs = (PcsPerBox) discPcs.getValue();
    PcsPerBox cdPcs = (PcsPerBox) coatedPcs.getValue();
    PcsPerBox ddPcs = (PcsPerBox) drumsPcs.getValue();
    PcsPerBox moIns = (PcsPerBox) montIns.getValue();
    //inMemoryClientsDB.getClients().add(new Clients(number,name,));
    controller.getClientTable();
  };


  EventHandler<MouseEvent> clear = cl -> {
    idField.clear();
    nameField.clear();
  };

  private void setDiscPcs() {
    discPcs.getItems().addAll(PcsPerBox.values());
    coatedPcs.getItems().addAll(PcsPerBox.values());
    drumsPcs.getItems().addAll(PcsPerBox.values());
    montIns.getItems().addAll(MountInstruction.values());
  }
}

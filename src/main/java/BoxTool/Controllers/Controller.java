package BoxTool.Controllers;

import BoxTool.Services.DatabaseBoxService;
import BoxTool.UI.Frames.AddFrame;
import BoxTool.UI.Frames.SceneChanges;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
@Data
public class Controller {


  private SceneChanges sc;

  private DatabaseBoxService boxService;

  private AddFrame addFrame;

  private AddFrame addCFrame;

  @FXML
  private AnchorPane pnl_discs;
  @FXML
  private AnchorPane pnl_clients;
  @FXML
  private AnchorPane pnl_boxes;
  @FXML
  private AnchorPane pnl_conf;
  @FXML
  private JFXButton dButton;
  @FXML
  private JFXButton cButton;
  @FXML
  private JFXButton bButton;
  @FXML
  private JFXButton cfgButton;
  @FXML
  private JFXButton boxAddDB;
  @FXML
  private JFXButton addConf;
  @FXML
  private TableView boxTable;
  @FXML
  private TableColumn sizeCol;
  @FXML
  private TableColumn heightCol;
  @FXML
  private TableColumn widthCol;
  @FXML
  private TabPane tabPane;

  @Autowired
  public Controller(SceneChanges sc,
                    DatabaseBoxService boxService,
                    @Qualifier("boxFrame") AddFrame addFrame,
                    @Qualifier("confFrame") AddFrame addCFrame) {
    this.sc = sc;
    this.boxService = boxService;
    this.addFrame = addFrame;
    this.addCFrame = addCFrame;
  }

  @FXML
  void initialize() throws FileNotFoundException {
    buttonInit();
    initBoxTable();
  }

  private void buttonInit() {
    dButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initDiscPanel);
    cButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initClientPanel);
    bButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initBoxPanel);
    cfgButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initConfPanel);
    boxAddDB.addEventHandler(MouseEvent.MOUSE_CLICKED, boxFramePath);
    addConf.addEventHandler(MouseEvent.MOUSE_CLICKED, confFramePath);
  }

  private void initBoxTable() throws FileNotFoundException {
    boxService.databaseDiscReader();
    boxTable.setItems(boxService.getData());
    boxService.initBoxTable(sizeCol, heightCol, widthCol);
  }

  private EventHandler<MouseEvent> initDiscPanel = IDP ->
          sc.initDiscPanel(pnl_discs, pnl_clients, pnl_boxes, pnl_conf);

  private EventHandler<MouseEvent> initClientPanel = ICP ->
          sc.initClientPanel(pnl_discs, pnl_clients, pnl_boxes, pnl_conf);

  private EventHandler<MouseEvent> initBoxPanel = IBP ->
          sc.initBoxPanel(pnl_discs, pnl_clients, pnl_boxes, pnl_conf);

  private EventHandler<MouseEvent> initConfPanel = ICfgP ->
          sc.initConfPanel(pnl_discs, pnl_clients, pnl_boxes, pnl_conf);

  private EventHandler<MouseEvent> boxFramePath = adder ->
          addFrame.add();

  private EventHandler<MouseEvent> confFramePath = adder ->
          addCFrame.add();
}

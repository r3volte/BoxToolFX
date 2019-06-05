package BoxTool.Controllers;

import BoxTool.Services.DatabaseBoxService;
import BoxTool.Services.DatabaseDiscService;
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

  @Autowired
  private SceneChanges sc;
  @Autowired
  private DatabaseBoxService boxService;
  @Autowired
  @Qualifier("dService")
  private DatabaseDiscService discService;
  @Autowired
  @Qualifier("boxFrame")
  private AddFrame addFrame;
  @Autowired
  @Qualifier("confFrame")
  private AddFrame addCFrame;
  @Autowired
  @Qualifier("discFrame")
  private AddFrame addDFrame;
  @Autowired
  @Qualifier("searchFrame")
  private AddFrame searchFrame;

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
  private JFXButton addDisc;
  @FXML
  private JFXButton searchButton;
  @FXML
  private TableView boxTable;
  @FXML
  private TableView discTable;
  @FXML
  private TableColumn sizeCol;
  @FXML
  private TableColumn heightCol;
  @FXML
  private TableColumn widthCol;
  @FXML
  private TableColumn numberCol;
  @FXML
  private TableColumn dCol;
  @FXML
  private TableColumn hCol;
  @FXML
  private TableColumn h2Col;
  @FXML
  private TableColumn wCol;
  @FXML
  private TabPane tabPane;


  @FXML
  void initialize() throws FileNotFoundException {
    buttonInit();
    initBoxTable();
    initDiscTable();
  }

  private void buttonInit() {
    dButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initDiscPanel);
    cButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initClientPanel);
    bButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initBoxPanel);
    cfgButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initConfPanel);
    boxAddDB.addEventHandler(MouseEvent.MOUSE_CLICKED, boxFramePath);
    addConf.addEventHandler(MouseEvent.MOUSE_CLICKED, confFramePath);
    addDisc.addEventHandler(MouseEvent.MOUSE_CLICKED, discFramePath);
    searchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, discSearchPath);
  }

  public void initBoxTable() throws FileNotFoundException {
    boxService.databaseBoxReader();
    boxTable.setItems(boxService.getData());
    boxService.initBoxTable(sizeCol, heightCol, widthCol);
  }

  public void initDiscTable() throws FileNotFoundException {
    discService.databaseDiscReader();
    discTable.setItems(discService.getData());
    discService.initDiscTable(numberCol, dCol, hCol, h2Col, wCol);
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

  private EventHandler<MouseEvent> discFramePath = adder ->
          addDFrame.add();

  private EventHandler<MouseEvent> discSearchPath = adder ->
          searchFrame.add();

}

package boxTool.controllers;

import boxTool.BoxToolApplication;
import boxTool.services.DatabaseBoxService;
import boxTool.services.DatabaseClientService;
import boxTool.services.DatabaseDiscService;
import boxTool.ui.AddFrame;
import boxTool.ui.SceneChanges;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
  private JFXButton boxAddDB;
  @FXML
  private JFXButton addDisc;
  @FXML
  private JFXButton addClient;
  @FXML
  private JFXButton help;
  @FXML
  private JFXButton searchButton;
  @FXML
  private TableView boxTable;
  @FXML
  private TableView discTable;
  @FXML
  private TableView clientTable;
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
  private TableColumn idCol;
  @FXML
  private TableColumn nameCol;
  @FXML
  private TableColumn discConfCol;
  @FXML
  private TableColumn discPcsCol;
  @FXML
  private TableColumn coatedConfCol;
  @FXML
  private TableColumn coatedPcsCol;
  @FXML
  private TableColumn drumsConfCol;
  @FXML
  private TableColumn drumsPcsCol;
  @FXML
  private TableColumn montCol;
  @FXML
  private TabPane tabPane;
  private SceneChanges sc;
  private DatabaseBoxService boxService;
  private DatabaseDiscService discService;
  private DatabaseClientService clientService;
  private AddFrame addFrame;
  private AddFrame addClFrame;
  private AddFrame addDFrame;
  private AddFrame searchFrame;
  private BoxToolApplication boxToolApplication;

  @Autowired
  public void setSc(SceneChanges sc) {
    this.sc = sc;
  }

  @Autowired
  public void setBoxToolApplication(BoxToolApplication boxToolApplication) {
    this.boxToolApplication = boxToolApplication;
  }

  @Autowired
  public void setBoxService(DatabaseBoxService boxService) {
    this.boxService = boxService;
  }

  @Autowired
  public void setDiscService(@Qualifier("dService") DatabaseDiscService discService) {
    this.discService = discService;
  }

  @Autowired
  public void setClientService(@Qualifier("clService") DatabaseClientService clientService) {
    this.clientService = clientService;
  }

  @Autowired
  public void setAddFrame(@Qualifier("boxFrame") AddFrame addFrame) {
    this.addFrame = addFrame;
  }

  @Autowired
  public void setAddClFrame(@Qualifier("clientFrame") AddFrame addClFrame) {
    this.addClFrame = addClFrame;
  }

  @Autowired
  public void setAddDFrame(@Qualifier("discFrame") AddFrame addDFrame) {
    this.addDFrame = addDFrame;
  }

  @Autowired
  public void setSearchFrame(@Qualifier("searchFrame") AddFrame searchFrame) {
    this.searchFrame = searchFrame;
  }

  @FXML
  void initialize() throws FileNotFoundException {
    buttonInit();
    initBoxTable();
    initDiscTable();
    intClientTable();
  }

  private void buttonInit() {
    dButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initDiscPanel);
    cButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initClientPanel);
    bButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initBoxPanel);
    boxAddDB.addEventHandler(MouseEvent.MOUSE_CLICKED, boxFramePath);
    addDisc.addEventHandler(MouseEvent.MOUSE_CLICKED, discFramePath);
    addClient.addEventHandler(MouseEvent.MOUSE_CLICKED, clientFramePath);
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

  public void intClientTable() throws FileNotFoundException {
    clientService.databaseClientReader();
    clientTable.setItems(clientService.getData());
    clientService.initClientTable(idCol, nameCol, discConfCol,
            discPcsCol, coatedConfCol, coatedPcsCol,
            drumsConfCol, drumsPcsCol, montCol);
  }

  private EventHandler<MouseEvent> initDiscPanel = IDP ->
          sc.initDiscPanel(pnl_discs, pnl_clients, pnl_boxes, pnl_conf);

  private EventHandler<MouseEvent> initClientPanel = ICP ->
          sc.initClientPanel(pnl_discs, pnl_clients, pnl_boxes, pnl_conf);

  private EventHandler<MouseEvent> initBoxPanel = IBP ->
          sc.initBoxPanel(pnl_discs, pnl_clients, pnl_boxes, pnl_conf);


  private EventHandler<MouseEvent> boxFramePath = adder ->
          addFrame.add();

  private EventHandler<MouseEvent> clientFramePath = adder ->
          addClFrame.add();

  private EventHandler<MouseEvent> discFramePath = adder ->
          addDFrame.add();

  private EventHandler<MouseEvent> discSearchPath = adder ->
          searchFrame.add();
}

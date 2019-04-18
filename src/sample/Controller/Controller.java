package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.Getter;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.ObservLists.ObBoxList;
import sample.Application.ObservLists.ObClientList;
import sample.Application.ObservLists.ObDiscList;
import sample.Controller.Events.ClientEvents.AddClientEvents;
import sample.Controller.Events.DiscEvents.AddDiscEvents;
import sample.Controller.Events.DiscEvents.SearchEvent;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

  @FXML
  @Getter
  private TableColumn numberCol;
  @FXML
  private TableColumn dCol;
  @FXML
  private TableColumn hCol;
  @FXML
  private TableColumn h2Col;
  @FXML
  private TableColumn wCol;
  public TableColumn sizeCol;
  public TableColumn widthCol;
  public TableColumn heightCol;
  public TableColumn idCol;
  public TableColumn nameCol;
  public TableColumn discConfCol;
  public TableColumn discPcsCol;
  public TableColumn coatedConfCol;
  public TableColumn coatedPcsCol;
  public TableColumn drumsConfCol;
  public TableColumn drumsPcsCol;
  public TableColumn montCol;
  @FXML
  @Getter
  private TableView discTable;
  @FXML
  private TableView boxTable;
  @FXML
  private TableView clientTable;
  private ObservableList dataD;
  private ObservableList dataB;
  private ObservableList dataC;
  @FXML
  private AnchorPane pnl_discs;
  @FXML
  private AnchorPane pnl_clients;
  @FXML
  private AnchorPane pnl_boxes;
  @FXML
  private JFXButton addDisc;
  @FXML
  private JFXButton addClient;
  @FXML
  private JFXButton refresh;
  @FXML
  private JFXButton searchButton;
  @FXML
  private JFXButton dButton;
  @FXML
  private JFXButton cButton;
  @FXML
  private JFXButton bButton;
  @FXML
  private TextField discCount;
  private static final Logger logger = Logger.getLogger(Controller.class.getName());


  @FXML
  void initialize() {
    initDiscTableContent();
    initDiscData();
    initBoxTableContent();
    initBoxData();
    initClientTableContent();
    initClientData();
    discTable.setItems(dataD);
    boxTable.setItems(dataB);
    clientTable.setItems(dataC);
    discCount();

    addDisc.addEventHandler(MouseEvent.MOUSE_CLICKED, addD);
    addClient.addEventHandler(MouseEvent.MOUSE_CLICKED, addC);
    refresh.addEventHandler(MouseEvent.MOUSE_CLICKED, refreshTab);
    searchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, search);
    dButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initDiscPanel);
    cButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initClientPanel);
    bButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initBoxPanel);
  }

  private void initDiscTableContent() {
    ObDiscList obDiscList = new ObDiscList();
    dataD = obDiscList.getData();
  }

  private void initDiscData() {
    numberCol.setCellValueFactory(new PropertyValueFactory("number"));
    dCol.setCellValueFactory(new PropertyValueFactory("diameter"));
    hCol.setCellValueFactory(new PropertyValueFactory("height"));
    h2Col.setCellValueFactory(new PropertyValueFactory("height2"));
    wCol.setCellValueFactory(new PropertyValueFactory("weight"));
  }

  private void initBoxTableContent() {
    ObBoxList obBoxList = new ObBoxList();
    dataB = obBoxList.getData();
  }

  private void initClientData() {
    idCol.setCellValueFactory(new PropertyValueFactory("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory("name"));
    discConfCol.setCellValueFactory(new PropertyValueFactory("discConf"));
    discPcsCol.setCellValueFactory(new PropertyValueFactory("discPcsPerBox"));
    coatedConfCol.setCellValueFactory(new PropertyValueFactory("coatedConf"));
    coatedPcsCol.setCellValueFactory(new PropertyValueFactory("coatedPcsPerBox"));
    drumsConfCol.setCellValueFactory(new PropertyValueFactory("drumConf"));
    drumsPcsCol.setCellValueFactory(new PropertyValueFactory("drumPcsPerBox"));
    montCol.setCellValueFactory(new PropertyValueFactory("montInst"));
  }

  private void initClientTableContent() {
    ObClientList obClientList = new ObClientList();
    dataC = obClientList.getData();
  }

  private void initBoxData() {
    sizeCol.setCellValueFactory(new PropertyValueFactory("number"));
    heightCol.setCellValueFactory(new PropertyValueFactory("height"));
    widthCol.setCellValueFactory(new PropertyValueFactory("width"));
  }


  private EventHandler<MouseEvent> addD = adder -> {
    AddDiscEvents events = new AddDiscEvents();
    events.addDisc();
  };
  private EventHandler<MouseEvent> addC = adder -> {
    AddClientEvents events = new AddClientEvents();
    events.addClient();
  };
  private EventHandler<MouseEvent> refreshTab = ref -> {
    discTable.refresh();
    logger.log(Level.FINE, "Refresh");
  };

  private EventHandler<MouseEvent> search = a -> {
    SearchEvent events = new SearchEvent();
    events.searchDisc();
  };

  private EventHandler<MouseEvent> initDiscPanel = idp ->{
    pnl_discs.toFront();
    pnl_discs.setVisible(true);
    pnl_clients.setVisible(false);
    pnl_boxes.setVisible(false);
  };

  private EventHandler<MouseEvent> initClientPanel = icp -> {
    pnl_clients.toFront();
    pnl_clients.setVisible(true);
    pnl_discs.setVisible(false);
    pnl_boxes.setVisible(false);
  };
  private EventHandler<MouseEvent> initBoxPanel = ibp -> {
    pnl_boxes.toFront();
    pnl_boxes.setVisible(true);
    pnl_discs.setVisible(false);
    pnl_clients.setVisible(false);
  };

  private void discCount() {
    InMemoryDiscsDB db;
    db = new InMemoryDiscsDB();
    int count = db.getDiscs().size();
    discCount.appendText(String.valueOf(count));
  }
}

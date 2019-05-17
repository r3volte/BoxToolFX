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
import sample.Application.Data.Box;
import sample.Application.Databases.InMemoryBoxDB;
import sample.Application.Databases.InMemoryClientsDB;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.Databases.InMemoryRepo;
import sample.Application.ObservLists.ObsList;
import sample.Controller.Events.AddEvent;
import sample.Controller.Events.BoxEvents.AddBoxAddEvent;
import sample.Controller.Events.ClientEvents.AddClientAddEvent;
import sample.Controller.Events.ConfEvent.AddConfAddEvent;
import sample.Controller.Events.DiscEvents.AddDiscAddEvent;
import sample.Controller.Events.DiscEvents.SearchEvent;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

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
  private TableColumn<Box, Integer> sizeCol;
  @FXML
  private TableColumn<Box, Integer> widthCol;
  @FXML
  private TableColumn<Box, Integer> heightCol;
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
  @Getter
  private TableView discTable;
  @FXML
  @Getter
  private TableView boxTable;
  @FXML
  @Getter
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
  private AnchorPane pnl_conf;
  @FXML
  private JFXButton addDisc;
  @FXML
  private JFXButton addClient;
  @FXML
  private JFXButton addBox;
  @FXML
  private JFXButton addBoxesConf;
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
  private JFXButton cfgButton;
  @FXML
  private TextField discCount;

  private static final Logger logger = Logger.getLogger(Controller.class.getName());


  @FXML
  void initialize() {
    initDiscData();
    initTableContent();
    initBoxData();
    initClientData();
    discTable.setItems(dataD);
    boxTable.setItems(dataB);
    clientTable.setItems(dataC);
    discCount();

    addDisc.addEventHandler(MouseEvent.MOUSE_CLICKED, addD);
    addClient.addEventHandler(MouseEvent.MOUSE_CLICKED, addC);
    addBox.addEventHandler(MouseEvent.MOUSE_CLICKED, addB);
    addBoxesConf.addEventHandler(MouseEvent.MOUSE_CLICKED, addConf);
    refresh.addEventHandler(MouseEvent.MOUSE_CLICKED, refreshTab);
    searchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, search);
    dButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initDiscPanel);
    cButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initClientPanel);
    bButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initBoxPanel);
    cfgButton.addEventHandler(MouseEvent.MOUSE_CLICKED, initConfPanel);
  }


  private void initDiscData() {
    numberCol.setCellValueFactory(new PropertyValueFactory("number"));
    dCol.setCellValueFactory(new PropertyValueFactory("diameter"));
    hCol.setCellValueFactory(new PropertyValueFactory("height"));
    h2Col.setCellValueFactory(new PropertyValueFactory("height2"));
    wCol.setCellValueFactory(new PropertyValueFactory("weight"));
  }

  private void initTableContent() {
    ObsList list;
    list = new ObsList(new InMemoryRepo(
            new InMemoryClientsDB(), new InMemoryDiscsDB(), new InMemoryBoxDB()));
    dataB = list.getData(list.getRepo().getBoxDB().getBox());
    dataD = list.getData(list.getRepo().getDiscsDB().getDiscs());
    dataC = list.getData(list.getRepo().getClientsDB().getClients());
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

  private void initBoxData() {
    sizeCol.setCellValueFactory(new PropertyValueFactory<Box, Integer>("number"));
    heightCol.setCellValueFactory(new PropertyValueFactory<Box, Integer>("height"));
    widthCol.setCellValueFactory(new PropertyValueFactory<Box, Integer>("width"));
  }

  private EventHandler<MouseEvent> addD = adder -> {
    AddEvent events = new AddDiscAddEvent();
    events.add();
  };

  private EventHandler<MouseEvent> addC = adder -> {
    AddEvent events = new AddClientAddEvent();
    events.add();
  };

  private EventHandler<MouseEvent> addB = adder -> {
    AddEvent events = new AddBoxAddEvent();
    events.add();
  };

  private EventHandler<MouseEvent> addConf = adder -> {
    AddEvent events = new AddConfAddEvent();
    events.add();
  };

  private EventHandler<MouseEvent> refreshTab = ref -> {
    discTable.refresh();
    logger.log(Level.FINE, "Refresh");
  };

  private EventHandler<MouseEvent> search = a -> {
    SearchEvent events = new SearchEvent();
    events.searchDisc();
  };

  private EventHandler<MouseEvent> initDiscPanel = idp -> {
    pnl_discs.toFront();
    pnl_discs.setVisible(true);
    pnl_clients.setVisible(false);
    pnl_boxes.setVisible(false);
    pnl_conf.setVisible(false);
  };

  private EventHandler<MouseEvent> initClientPanel = icp -> {
    pnl_clients.toFront();
    pnl_clients.setVisible(true);
    pnl_discs.setVisible(false);
    pnl_boxes.setVisible(false);
    pnl_conf.setVisible(false);
  };

  private EventHandler<MouseEvent> initBoxPanel = ibp -> {
    pnl_boxes.toFront();
    pnl_boxes.setVisible(true);
    pnl_discs.setVisible(false);
    pnl_clients.setVisible(false);
    pnl_conf.setVisible(false);
  };
  private EventHandler<MouseEvent> initConfPanel = iCop -> {
    pnl_conf.toFront();
    pnl_conf.setVisible(true);
    pnl_discs.setVisible(false);
    pnl_clients.setVisible(false);
    pnl_boxes.setVisible(false);
  };

  private void discCount() {
    InMemoryDiscsDB db;
    db = new InMemoryDiscsDB();
    int count = db.getDiscs().size();
    discCount.appendText(String.valueOf(count));
  }
}

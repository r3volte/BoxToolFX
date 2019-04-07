package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.ObservLists.ObBoxList;
import sample.Application.ObservLists.ObClientList;
import sample.Application.ObservLists.ObDiscList;
import sample.Controller.Events.AddDiscEvents;
import sample.Controller.Events.SearchEvent;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

  @FXML
  @Getter
  public TableColumn numberCol;
  public TableColumn dCol;
  public TableColumn hCol;
  public TableColumn h2Col;
  public TableColumn wCol;
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
  public TableView discTable;
  public TableView boxTable;
  public TableView clientTable;
  private ObservableList dataD;
  private ObservableList dataB;
  private ObservableList dataC;
  public JFXButton addDisc;
  public JFXButton refresh;
  public JFXButton searchButton;
  public JFXTextArea discCount;
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

    addDisc.addEventHandler(MouseEvent.MOUSE_CLICKED, add);
    refresh.addEventHandler(MouseEvent.MOUSE_CLICKED, refreshTab);
    searchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, search);
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


  EventHandler<MouseEvent> add = adder -> {
    AddDiscEvents events = new AddDiscEvents();
    events.addDisc();
  };
  EventHandler<MouseEvent> refreshTab = ref -> {
    discTable.refresh();
    logger.log(Level.FINE,"Refresh");
  };

  EventHandler<MouseEvent> search = a -> {
    SearchEvent events = new SearchEvent();
    events.searchDisc();
  };


  private void discCount() {
    InMemoryDiscsDB db;
    db = new InMemoryDiscsDB();
    int count = db.getDiscs().size();
    discCount.appendText(String.valueOf(count));
  }
}

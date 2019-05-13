package sample.Controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;

import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryBoxDB;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.FileOpe.Readers.ChooseFileReader;
import sample.Application.ObservLists.ObSearchDisc;
import sample.Application.Selecting.BoxSelector;
import sample.Application.Selecting.SelectDisc;


public class SearchController {

  @FXML
  @Getter
  private JFXButton searchSubmit;
  @FXML
  private JFXButton multipleSearchButton;
  @FXML
  private TextField numField;
  @FXML
  private TableView searchDiscView;
  @FXML
  private TableColumn searchNumber;
  @FXML
  private TableColumn searchDiameter;
  @FXML
  private TableColumn searchHeight;
  @FXML
  private TableColumn searchDoubHei;
  @FXML
  private TableColumn searchWeight;
  @FXML
  private TableView selectedBox;
  @FXML
  private TableColumn numberSelected;
  @FXML
  private TableColumn heightSelected;
  @FXML
  private TableColumn widthSelected;

  private BoxSelector boxSelector = new BoxSelector();
  private InMemoryBoxDB boxDB = new InMemoryBoxDB();
  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();
  private ObSearchDisc obSearchDisc = new ObSearchDisc();
  private SelectDisc selectDisc = new SelectDisc();


  @FXML
  void initialize() {
    initDiscData();
    initSearchBox();
    searchSubmit.addEventHandler(MouseEvent.MOUSE_CLICKED, search);
    multipleSearchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, fileChooser);
    numField.setOnKeyPressed(getKeyEventEventHandler());

  }

  private EventHandler<KeyEvent> getKeyEventEventHandler() {
    return event -> {
      if (event.getCode().equals(KeyCode.ENTER)) {
        int number = getNumber();
        selectedBox.setItems(obSearchDisc
                .getDataBox(boxSelector
                        .selectBox(selectDisc
                                .searchDisc(discsDB
                                        .getDiscs(), number), boxDB.getBox())));
      }
    };
  }

  private int getNumber() {
    int number = Integer.parseInt(numField.getText());
    searchDiscView.setItems(obSearchDisc
            .getDataDisc(selectDisc
                    .searchDisc(discsDB
                            .getDiscs(), number)));
    return number;
  }

  EventHandler<MouseEvent> search = ok -> {
    int number = getNumber();
    selectedBox.setItems(obSearchDisc
            .getDataBox(boxSelector
                    .selectBox(selectDisc
                            .searchDisc(discsDB.getDiscs(), number), boxDB.getBox())));
  };

  private void initDiscData() {
    searchNumber.setCellValueFactory(new PropertyValueFactory("number"));
    searchDiameter.setCellValueFactory(new PropertyValueFactory("diameter"));
    searchHeight.setCellValueFactory(new PropertyValueFactory("height"));
    searchDoubHei.setCellValueFactory(new PropertyValueFactory("height2"));
    searchWeight.setCellValueFactory(new PropertyValueFactory("weight"));
  }

  private void initSearchBox() {
    numberSelected.setCellValueFactory(new PropertyValueFactory("number"));
    heightSelected.setCellValueFactory(new PropertyValueFactory("height"));
    widthSelected.setCellValueFactory(new PropertyValueFactory("width"));
  }

  EventHandler<MouseEvent> fileChooser = f -> {
    ChooseFileReader in = new ChooseFileReader();
    try {
      List<Discs> myList = in.fileReader(discsDB);
      searchDiscView.setItems(obSearchDisc.getDataDisc(myList));
      selectedBox.setItems(obSearchDisc.getDataBox(boxSelector.selectBox(myList, boxDB.getBox())));
    } catch (IOException e) {
      e.printStackTrace();
    }

  };
}

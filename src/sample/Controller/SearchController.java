package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import lombok.Getter;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.ObservLists.ObSearchDisc;
import sample.Application.Selecting.SelectDisc;

import java.io.File;


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
  void initialize() {
    initDiscData();
    searchSubmit.addEventHandler(MouseEvent.MOUSE_CLICKED, search);
    multipleSearchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, fileChooser);
  }

  EventHandler<MouseEvent> search = ok -> {
    int number = Integer.parseInt(numField.getText());
    InMemoryDiscsDB discsDB = new InMemoryDiscsDB();
    ObSearchDisc obSearchDisc = new ObSearchDisc();
    SelectDisc selectDisc = new SelectDisc();
    searchDiscView.setItems(obSearchDisc.getData(selectDisc.searchDisc(discsDB.getDiscs(), number)));
  };

  private void initDiscData() {
    searchNumber.setCellValueFactory(new PropertyValueFactory("number"));
    searchDiameter.setCellValueFactory(new PropertyValueFactory("diameter"));
    searchHeight.setCellValueFactory(new PropertyValueFactory("height"));
    searchDoubHei.setCellValueFactory(new PropertyValueFactory("height2"));
    searchWeight.setCellValueFactory(new PropertyValueFactory("weight"));
  }

  EventHandler<MouseEvent> fileChooser = f -> {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt file","*.txt"));
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      System.out.println(file.getAbsoluteFile());
    }
  };
}

package BoxTool.Services;

import BoxTool.Controllers.Controller;
import BoxTool.Data.Box;
import BoxTool.FileResources.Resources;
import BoxTool.DatabaseOperations.ListType;
import BoxTool.DatabaseOperations.Read.DatabaseFileRead;
import BoxTool.Repository.ConfigurationsRepository;
import BoxTool.Repository.DataRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.CheckComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseConfService {

  @Autowired
  private ConfigurationsRepository dataRepository;

  @Autowired
  private DatabaseFileRead databaseFileRead;

  @Autowired
  @Qualifier("bRepo")
  private DataRepository dataBoxRepository;


  public void databaseConfigReaderReader() throws FileNotFoundException {
    databaseFileRead.databaseConfReader(Resources.ConfDBFile(),
            dataRepository.getComponent(),
            ListType.listTypeConf());
  }

  public void createConf(TextField confName, Controller controller, CheckComboBox<String> comboList) {
    String name = confName.getText();
    Tab tab = new Tab(name);
    controller.getTabPane().getTabs().add(tab);
    TableView newTable = new TableView();
    tab.setContent(newTable);
    TableColumn numTable = new TableColumn("Number");
    TableColumn wTable = new TableColumn("Width");
    TableColumn hTable = new TableColumn("Height");
    newTable.getColumns().addAll(numTable, wTable, hTable);
//    dataRepository.add(name, 0,0,0);
//    numTable.setCellValueFactory(new PropertyValueFactory("number"));
//    wTable.setCellValueFactory(new PropertyValueFactory("width"));
//    hTable.setCellValueFactory(new PropertyValueFactory("height"));
//    newTable.setItems(getData());
    Map<String, Integer> myMap = new HashMap<>();
    myMap.put("Jedne", 1);
    myMap.put("Dwa", 2);
    myMap.put("Trzy", 3);
    comboList.getItems().addAll(myMap.keySet());
   // comboList.getItems().setAll(myMap.keySet());
  }

  private ObservableList getData() {
    return FXCollections.observableArrayList(dataBoxRepository.getComponent());
  }
}

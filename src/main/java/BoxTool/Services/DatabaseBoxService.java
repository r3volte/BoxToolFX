package BoxTool.Services;

import BoxTool.FileResources.Resources;
import BoxTool.DatabaseOperations.ListType;
import BoxTool.DatabaseOperations.Read.DatabaseFileRead;
import BoxTool.DatabaseOperations.Write.DatabaseFileWrite;
import BoxTool.Repository.DataRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service(value = "bService")
public class DatabaseBoxService {


  @Autowired
  @Qualifier("bRepo")
  private DataRepository dataRepository;

  @Autowired
  private DatabaseFileRead databaseFileRead;

  @Autowired
  private DatabaseFileWrite databaseFileWrite;

  public void databaseDiscReader() throws FileNotFoundException {
    databaseFileRead.databaseReader(Resources.BoxDBFile(),
            dataRepository.getComponent(),
            ListType.listBox());
    System.out.println(dataRepository.getComponent().toString());
  }

  public void databaseBoxWriter() throws IOException {
    databaseFileWrite.save(Resources.BoxDBFile(), dataRepository.fileConverter(dataRepository.getComponent()));
  }

  public void initBoxTable(TableColumn sizeCol, TableColumn heightCol, TableColumn widthCol) {
    sizeCol.setCellValueFactory(new PropertyValueFactory("number"));
    heightCol.setCellValueFactory(new PropertyValueFactory("height"));
    widthCol.setCellValueFactory(new PropertyValueFactory("width"));
  }

  public void addNewBox() {
    System.out.println("dupadsadsadsadsad");
    System.out.println(dataRepository.getComponent());
//    Integer first = Integer.valueOf(numBox.getText());
//    Integer second = Integer.valueOf(boxWidth.getText());
//    Integer third = Integer.valueOf(boxHeight.getText());
  }

  public ObservableList getData() {
    return FXCollections.observableArrayList(dataRepository.getComponent());
  }
}

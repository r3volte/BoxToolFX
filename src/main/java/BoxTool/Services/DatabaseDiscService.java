package BoxTool.Services;

import BoxTool.Controllers.Controller;
import BoxTool.Data.Box;
import BoxTool.Data.Discs;
import BoxTool.DatabaseOperations.ListType;
import BoxTool.DatabaseOperations.Read.DatabaseFileRead;
import BoxTool.DatabaseOperations.Write.DatabaseFileWrite;
import BoxTool.FileResources.Resources;
import BoxTool.Repository.DataRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service(value = "dService")
public class DatabaseDiscService {

  @Autowired
  @Qualifier("dRepo")
  private DataRepository dataRepository;

  @Autowired
  private DatabaseFileRead databaseFileRead;

  @Autowired
  private DatabaseFileWrite databaseFileWrite;

  public void databaseDiscReader() throws FileNotFoundException {
    databaseFileRead.databaseReader(Resources.DiscDBFile(),
            dataRepository.getComponent(),
            ListType.listDisk());
    System.out.println(dataRepository.getComponent().toString());
  }

  private void databaseDiscWriter() throws IOException {
    databaseFileWrite.save(Resources.DiscDBFile(), dataRepository.fileConverter(dataRepository.getComponent()));
  }

  public void initDiscTable(TableColumn numberCol, TableColumn dCol,
                            TableColumn hCol, TableColumn h2Col, TableColumn wCol) {
    numberCol.setCellValueFactory(new PropertyValueFactory("number"));
    dCol.setCellValueFactory(new PropertyValueFactory("diameter"));
    hCol.setCellValueFactory(new PropertyValueFactory("height"));
    h2Col.setCellValueFactory(new PropertyValueFactory("height2"));
    wCol.setCellValueFactory(new PropertyValueFactory("weight"));
  }

  public void addNewBox(TextField numField, TextField diaField, TextField hField, TextField wField) {
      Integer first = Integer.valueOf(numField.getText());
      Double second = Double.valueOf(diaField.getText());
      Double third = Double.valueOf(hField.getText());
      Double four = Double.valueOf(wField.getText());
      dataRepository.add(new Discs(first, second, third,third * 2.0, four));
    System.out.println(dataRepository.getComponent());
  }

  public void refreshTable(Controller controller) {
    try {
      controller.getDiscTable().setVisible(false);
      controller.getDiscTable().setItems(controller
              .getDiscService().getData().sorted());
      controller.getDiscTable().setVisible(true);
      databaseDiscWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ObservableList getData() {
    return FXCollections.observableArrayList(dataRepository.getComponent());
  }

  public ObservableList getDataDisc(List<Discs> list) {
    return FXCollections.observableArrayList(list);
  }
}

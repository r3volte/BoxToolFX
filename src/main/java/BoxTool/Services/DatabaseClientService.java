package BoxTool.Services;

import BoxTool.DatabaseOperations.ListType;
import BoxTool.DatabaseOperations.Read.DatabaseFileRead;
import BoxTool.DatabaseOperations.Write.DatabaseFileWrite;
import BoxTool.FileResources.Resources;
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

@Service(value = "clService")
public class DatabaseClientService {

  @Autowired
  @Qualifier("client")
  private DataRepository dataRepository;

  @Autowired
  private DatabaseFileRead databaseFileRead;

  @Autowired
  private DatabaseFileWrite databaseFileWrite;

  public void databaseClientReader() throws FileNotFoundException {
    databaseFileRead.databaseReader(Resources.ClientDBFile(),
            dataRepository.getComponent(),
            ListType.listClient());
  }

  private void databaseClientWriter() throws IOException {
    databaseFileWrite.save(Resources.ClientDBFile(), dataRepository.fileConverter(dataRepository.getComponent()));
  }

  public void initClientTable(TableColumn id, TableColumn name, TableColumn discConf,
                              TableColumn discPcsPerBox, TableColumn coatedConf,
                              TableColumn coatedPcsPerBox, TableColumn drumConf,
                              TableColumn drumPcsPerBox, TableColumn montInst) {
    id.setCellValueFactory(new PropertyValueFactory("id"));
    name.setCellValueFactory(new PropertyValueFactory("name"));
    discConf.setCellValueFactory(new PropertyValueFactory("discConf"));
    discPcsPerBox.setCellValueFactory(new PropertyValueFactory("discPcsPerBox"));
    coatedConf.setCellValueFactory(new PropertyValueFactory("coatedConf"));
    coatedPcsPerBox.setCellValueFactory(new PropertyValueFactory("coatedPcsPerBox"));
    drumConf.setCellValueFactory(new PropertyValueFactory("drumConf"));
    drumPcsPerBox.setCellValueFactory(new PropertyValueFactory("drumPcsPerBox"));
    montInst.setCellValueFactory(new PropertyValueFactory("montInst"));
  }

  public ObservableList getData() {
    return FXCollections.observableArrayList(dataRepository.getComponent());
  }
}

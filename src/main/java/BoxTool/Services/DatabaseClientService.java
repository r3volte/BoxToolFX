package boxTool.services;

import boxTool.data.Box;
import boxTool.data.Clients;
import boxTool.data.MountInstruction;
import boxTool.data.PcsPerBox;
import boxTool.databaseOperations.ListType;
import boxTool.databaseOperations.read.DatabaseFileRead;
import boxTool.databaseOperations.write.DatabaseFileWrite;
import boxTool.fileResources.Resources;
import boxTool.repository.DataRepository;
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

@Service(value = "clService")
public class DatabaseClientService {


    private final DataRepository dataRepository;
    private final DatabaseFileRead databaseFileRead;
    private final DatabaseFileWrite databaseFileWrite;

    @Autowired
    public DatabaseClientService(@Qualifier("client") DataRepository dataRepository,
                                 DatabaseFileRead databaseFileRead,
                                 DatabaseFileWrite databaseFileWrite) {
        this.dataRepository = dataRepository;
        this.databaseFileRead = databaseFileRead;
        this.databaseFileWrite = databaseFileWrite;
    }

    public void databaseClientReader() throws FileNotFoundException {
        databaseFileRead.databaseReader(Resources.clientDBFile(),
                dataRepository.getComponent(),
                ListType.listClient());
    }

    private void databaseClientWriter() throws IOException {
        databaseFileWrite.save(Resources.clientDBFile(), dataRepository.fileConverter(dataRepository.getComponent()));
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

    public void addNewClient(TextField idField, TextField nameField, TextField discConfField,
                             TextField coatedConfField, TextField drumConfField, TextField montIns,
                             TextField discsPcs, TextField coatedPcs, TextField drumPcs) {
//        Integer first = Integer.valueOf(idField.getText());
//        String second = nameField.getText();
//        String third = discConfField.getText();
//        String four = coatedConfField.getText();
//        String five = drumConfField.getText();
//        dataRepository.add(new Clients(first, second,
//                third, discsPcs.getText(),
//                four, coatedPcs.getText(),
//                five, drumPcs.getText(),
//                montIns.getText()));
    }

    public ObservableList getData() {
        return FXCollections.observableArrayList(dataRepository.getComponent());
    }
}

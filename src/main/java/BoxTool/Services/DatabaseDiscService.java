package boxTool.services;

import boxTool.controllers.Controller;
import boxTool.data.Discs;
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
import java.util.List;

@Service(value = "dService")
public class DatabaseDiscService {

    private final DataRepository dataRepository;
    private final DatabaseFileRead databaseFileRead;
    private final DatabaseFileWrite databaseFileWrite;

    @Autowired
    public DatabaseDiscService(@Qualifier("dRepo") DataRepository dataRepository,
                               DatabaseFileRead databaseFileRead,
                               DatabaseFileWrite databaseFileWrite) {
        this.dataRepository = dataRepository;
        this.databaseFileRead = databaseFileRead;
        this.databaseFileWrite = databaseFileWrite;
    }

    public void databaseDiscReader() throws FileNotFoundException {
        databaseFileRead.databaseReader(Resources.discDBFile(),
                dataRepository.getComponent(),
                ListType.listDisk());
    }

    private void databaseDiscWriter() throws IOException {
        databaseFileWrite.save(Resources.discDBFile(), dataRepository.fileConverter(dataRepository.getComponent()));
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
        dataRepository.add(new Discs(first, second, third, third * 2.0, four));
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

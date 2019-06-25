package boxTool.services;

import boxTool.controllers.Controller;
import boxTool.data.Box;
import boxTool.fileResources.Resources;
import boxTool.databaseOperations.ListType;
import boxTool.databaseOperations.read.DatabaseFileRead;
import boxTool.databaseOperations.write.DatabaseFileWrite;
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

@Service(value = "bService")
public class DatabaseBoxService {


    private final DataRepository dataRepository;
    private final DatabaseFileRead databaseFileRead;
    private final DatabaseFileWrite databaseFileWrite;

    @Autowired
    public DatabaseBoxService(@Qualifier("bRepo") DataRepository dataRepository,
                              DatabaseFileRead databaseFileRead,
                              DatabaseFileWrite databaseFileWrite) {
        this.dataRepository = dataRepository;
        this.databaseFileRead = databaseFileRead;
        this.databaseFileWrite = databaseFileWrite;
    }

    public void databaseBoxReader() throws FileNotFoundException {
        databaseFileRead.databaseReader(Resources.boxDBFile(),
                dataRepository.getComponent(),
                ListType.listBox());
    }

    private void databaseBoxWriter() throws IOException {
        databaseFileWrite.save(Resources.boxDBFile(), dataRepository.fileConverter(dataRepository.getComponent()));
    }

    public void initBoxTable(TableColumn sizeCol, TableColumn heightCol, TableColumn widthCol) {
        sizeCol.setCellValueFactory(new PropertyValueFactory("number"));
        heightCol.setCellValueFactory(new PropertyValueFactory("height"));
        widthCol.setCellValueFactory(new PropertyValueFactory("width"));
    }

    public void addNewBox(TextField numBox, TextField boxWidth, TextField boxHeight) {
        Integer first = Integer.valueOf(numBox.getText());
        Integer second = Integer.valueOf(boxWidth.getText());
        Integer third = Integer.valueOf(boxHeight.getText());
        dataRepository.add(new Box(first, second, third));
        System.out.println(dataRepository.getComponent());
    }

    public void refreshTable(Controller controller) {
        try {
            controller.getBoxTable().setVisible(false);
            controller.getBoxTable()
                    .setItems(controller.getBoxService().getData().sorted());
            controller.getBoxTable().setVisible(true);
            databaseBoxWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList getData() {
        return FXCollections.observableArrayList(dataRepository.getComponent());
    }


    public ObservableList getDataBox(List<Box> list) {
        return FXCollections.observableArrayList(list);
    }
}

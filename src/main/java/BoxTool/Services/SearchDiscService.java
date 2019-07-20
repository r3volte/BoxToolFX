package boxTool.services;

import boxTool.data.Discs;
import boxTool.databaseOperations.read.ChooseFileReader;
import boxTool.selector.BoxSelector;
import boxTool.selector.SelectDisc;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Service(value = "searchService")
public class SearchDiscService {

    @Autowired
    private DatabaseDiscService databaseDiscService;
    @Autowired
    private SelectDisc selectDisc;
    @Autowired
    private BoxSelector boxSelector;
    @Autowired
    private DatabaseBoxService databaseBoxService;
    @Autowired
    private DatabaseConfService databaseConfService;


    public void initDiscData(TableColumn searchNumber, TableColumn searchDiameter,
                             TableColumn searchHeight, TableColumn searchDoubHei, TableColumn searchWeight) {
        searchNumber.setCellValueFactory(new PropertyValueFactory("number"));
        searchDiameter.setCellValueFactory(new PropertyValueFactory("diameter"));
        searchHeight.setCellValueFactory(new PropertyValueFactory("height"));
        searchDoubHei.setCellValueFactory(new PropertyValueFactory("height2"));
        searchWeight.setCellValueFactory(new PropertyValueFactory("weight"));
    }

    public void initSearchBox(TableColumn numberSelected, TableColumn heightSelected,
                              TableColumn widthSelected) {
        numberSelected.setCellValueFactory(new PropertyValueFactory("number"));
        heightSelected.setCellValueFactory(new PropertyValueFactory("height"));
        widthSelected.setCellValueFactory(new PropertyValueFactory("width"));
    }

    public void initFileChooser(TableView searchDiscView, TableView selectedBox, String string, TextArea result) {
        ChooseFileReader in = new ChooseFileReader();
        try {
            List<Discs> myList = in.fileReader(selectDisc, databaseDiscService);
            searchDiscView.setItems(databaseDiscService.getDataDisc(myList));
            selectedBox.setItems(databaseBoxService
                    .getDataBox(boxSelector
                            .selectBox(myList, databaseConfService.initComboList(string), result)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initComboConfigurationBox(ComboBox comboBox) {
        databaseConfService.configurationComboBox(comboBox);
    }

    public int getNumber(TableView searchDiscView, TextField numField) {
        int number = Integer.parseInt(numField.getText());
        searchDiscView.setItems(databaseDiscService
                .getDataDisc(selectDisc
                        .searchDisc(databaseDiscService.getData(), number)));
        return number;
    }

    public void searchBox(TableView selectedBox, int number, String string, TextArea result) {
        selectedBox.setItems(databaseBoxService
                .getDataBox(boxSelector.selectBox(selectDisc
                        .searchDisc(databaseDiscService
                                .getData(), number), databaseConfService.initComboList(string), result)));
    }
}

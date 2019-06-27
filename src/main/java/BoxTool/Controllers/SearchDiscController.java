package boxTool.controllers;

import boxTool.services.SearchDiscService;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchDiscController {

    @FXML
    private JFXButton searchSubmit;
    @FXML
    private JFXButton multipleSearchButton;
    @FXML
    private TextField numField;
    @FXML
    private ComboBox confBox;
    @FXML
    private TableView searchDiscView;
    @FXML
    private TableView selectedBox;
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
    private TableColumn numberSelected;
    @FXML
    private TableColumn heightSelected;
    @FXML
    private TableColumn widthSelected;
    @FXML
    private TextArea result;


    private SearchDiscService searchDiscService;

    @Autowired
    public void setSearchDiscService(SearchDiscService searchDiscService) {
        this.searchDiscService = searchDiscService;
    }

    @FXML
    void initialize() {
        searchDiscService.initDiscData(searchNumber, searchDiameter, searchHeight, searchDoubHei, searchWeight);
        searchDiscService.initSearchBox(numberSelected, heightSelected, widthSelected);
        searchSubmit.addEventHandler(MouseEvent.MOUSE_CLICKED, search);
        multipleSearchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, fileChooser);
        numField.setOnKeyPressed(getKeyEventEventHandler());
        searchDiscService.initComboConfigurationBox(confBox);
    }

    private EventHandler<KeyEvent> getKeyEventEventHandler() {
        return event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                searchDiscService
                        .searchBox(selectedBox, searchDiscService
                                .getNumber(searchDiscView, numField), String.valueOf(confBox.getValue()), result);
            }
        };
    }

    private EventHandler<MouseEvent> search = ok -> {
        searchDiscService
                .searchBox(selectedBox, searchDiscService.
                        getNumber(searchDiscView, numField), String.valueOf(confBox.getValue()), result);
    };

    private EventHandler<MouseEvent> fileChooser = f ->
            searchDiscService.initFileChooser(searchDiscView, selectedBox, result);

}

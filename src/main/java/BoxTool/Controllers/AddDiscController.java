package boxTool.controllers;

import boxTool.services.DatabaseDiscService;
import boxTool.ui.AddFrame;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDiscController {

    @FXML
    private JFXButton clearButton;
    @FXML
    private JFXButton submitButton;
    @FXML
    private TextField numField;
    @FXML
    private TextField diaField;
    @FXML
    private TextField hField;
    @FXML
    private TextField wField;

    private DatabaseDiscService databaseDiscService;
    private AddFrame boxFrame;
    private Controller controller;


    @Autowired
    public void setDatabaseBoxService(DatabaseDiscService databaseDiscService) {
        this.databaseDiscService = databaseDiscService;
    }

    @Autowired
    public void setBoxFrame(AddFrame boxFrame) {
        this.boxFrame = boxFrame;
    }

    @Autowired
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    void initialize() {
        clearButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
    }

    private EventHandler<MouseEvent> submitOk = ok -> {
        try {
            databaseDiscService.addNewBox(numField, diaField, hField, wField);
            databaseDiscService.refreshTable(controller);
        } catch (NumberFormatException e) {
            boxFrame.error();
        }
    };

    private EventHandler<MouseEvent> clear = cl -> {
        numField.clear();
        diaField.clear();
        hField.clear();
        wField.clear();
    };
}

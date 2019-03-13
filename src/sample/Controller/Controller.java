package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.Application.ObservLists.ObservDiscList;


public class Controller {

    @FXML
    public TableColumn numberCol, dCol, hCol, h2Col, wCol;
    public TableView discTable;
    private ObservableList data;
    private ObservDiscList observDiscList;
    public JFXButton addDisc;


    @FXML
    void initialize(){
        initTableContent();
        initData();
        discTable.setItems(data);
        addDisc.addEventHandler(MouseEvent.MOUSE_CLICKED,add);
    }

    private void initData(){
        numberCol.setCellValueFactory(new PropertyValueFactory("number"));
        dCol.setCellValueFactory(new PropertyValueFactory("diameter"));
        hCol.setCellValueFactory(new PropertyValueFactory("height"));
        h2Col.setCellValueFactory(new PropertyValueFactory("height2"));
        wCol.setCellValueFactory(new PropertyValueFactory("weight"));
    }

    private void initTableContent(){
        observDiscList = new ObservDiscList();
        data = observDiscList.getData();
    }

    EventHandler<MouseEvent> add = add -> {
    MouseEvents events = new MouseEvents();
    events.addDisc();
    };
}

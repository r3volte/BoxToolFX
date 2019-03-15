package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import sample.Application.ObservLists.ObservBoxList;
import sample.Application.ObservLists.ObservClientList;
import sample.Application.ObservLists.ObservDiscList;


public class Controller {

    @FXML @Getter
    public TableColumn numberCol, dCol, hCol,
                        h2Col, wCol, sizeCol,
                        widthCol, heightCol, idCol,
                        nameCol, discConfCol, discPcsCol,
                        coatedConfCol, coatedPcsCol, drumsConfCol,
                        drumsPcsCol, montCol;

    public TableView discTable, boxTable, clientTable;
    private ObservableList dataD, dataB, dataC;
    private ObservDiscList observDiscList;
    private ObservBoxList observBoxList;
    private ObservClientList observClientList;
    public JFXButton addDisc;
    public JFXButton refresh;


    @FXML
    void initialize(){
        initDiscTableContent();
        initDiscData();
        initBoxTableContent();
        initBoxData();
        initClientTableContent();
        initClientData();
        discTable.setItems(dataD);
        boxTable.setItems(dataB);
        clientTable.setItems(dataC);

        addDisc.addEventHandler(MouseEvent.MOUSE_CLICKED, add);
        refresh.addEventHandler(MouseEvent.MOUSE_CLICKED, refreshTab);
    }

    private void initDiscTableContent(){
        observDiscList = new ObservDiscList();
        dataD = observDiscList.getData();
    }

    private void initDiscData(){
        numberCol.setCellValueFactory(new PropertyValueFactory("number"));
        dCol.setCellValueFactory(new PropertyValueFactory("diameter"));
        hCol.setCellValueFactory(new PropertyValueFactory("height"));
        h2Col.setCellValueFactory(new PropertyValueFactory("height2"));
        wCol.setCellValueFactory(new PropertyValueFactory("weight"));
    }

    private void initBoxTableContent(){
        observBoxList = new ObservBoxList();
        dataB = observBoxList.getData();
    }

    private void initClientData(){
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        discConfCol.setCellValueFactory(new PropertyValueFactory("discConf"));
        discPcsCol.setCellValueFactory(new PropertyValueFactory("discPcsPerBox"));
        coatedConfCol.setCellValueFactory(new PropertyValueFactory("coatedConf"));
        coatedPcsCol.setCellValueFactory(new PropertyValueFactory("coatedPcsPerBox"));
        drumsConfCol.setCellValueFactory(new PropertyValueFactory("drumConf"));
        drumsPcsCol.setCellValueFactory(new PropertyValueFactory("drumPcsPerBox"));
        montCol.setCellValueFactory(new PropertyValueFactory("montInst"));
    }
    private void initClientTableContent(){
        observClientList = new ObservClientList();
        dataC = observClientList.getData();
    }

    private void initBoxData(){
        sizeCol.setCellValueFactory(new PropertyValueFactory("number"));
        heightCol.setCellValueFactory(new PropertyValueFactory("height"));
        widthCol.setCellValueFactory(new PropertyValueFactory("width"));
    }


    EventHandler<MouseEvent> add = add -> {
    MouseEvents events = new MouseEvents();
    events.addDisc();
    };
    EventHandler<MouseEvent> refreshTab = refresh -> {
        discTable.refresh();
        System.out.println("Refresh");
    };


}

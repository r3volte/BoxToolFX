//package sample.Controller.TableInits;
//
//import javafx.collections.ObservableList;
//import javafx.scene.control.cell.PropertyValueFactory;
//import sample.Application.ObservLists.ObDiscList;
//import sample.Controller.Controller;
//
//public class DiscTable {
//
//    private Controller controller = new Controller();
//    private ObservableList data;
//    private ObDiscList observDiscList;
//
//    public ObservableList getData() {
//        return data;
//    }
//
//    public void initTableContent(){
//        observDiscList = new ObDiscList();
//        data = observDiscList.getData();
//    }
//
//    public void initData(){
//        controller.getNumberCol().setCellValueFactory(new PropertyValueFactory("number"));
//        controller.getDCol().setCellValueFactory(new PropertyValueFactory("diameter"));
//        controller.getHCol().setCellValueFactory(new PropertyValueFactory("height"));
//        controller.getH2Col().setCellValueFactory(new PropertyValueFactory("height2"));
//        controller.wCol.setCellValueFactory(new PropertyValueFactory("weight"));
//    }
//}
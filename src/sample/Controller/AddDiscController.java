package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;

public class AddDiscController extends Controller implements InMemoryDiscsDB {

    @FXML
    public JFXButton clearButton, submitButton;

    public TextField numField;
    public TextField diaField;
    public TextField hField;
    public TextField wField;
    public StackPane rootPane;

    @FXML
    void initialize(){

        clearButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clear);
        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, submitOk);
    }

    EventHandler<MouseEvent> clear = cl -> {
        numField.clear();
        diaField.clear();
        hField.clear();
        wField.clear();
    };

    EventHandler<MouseEvent> submitOk = ok -> {
        try {
            int number = Integer.parseInt(numField.getText());
            double diameter = Double.parseDouble(diaField.getText());
            double height = Double.parseDouble(hField.getText());
            double heightX2 = height * 2;
            double weight = Double.parseDouble(wField.getText());
            discs.add(new Discs(number, diameter, height, heightX2, weight));
            discs.forEach(c -> System.out.println(c));
        } catch (NumberFormatException e){
            JFXDialogLayout layout;layout = new JFXDialogLayout();
            Button oks = new Button("Okey");
            JFXDialog error = new JFXDialog(rootPane,layout,JFXDialog.DialogTransition.TOP);
            oks.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent c )->{
                error.close();
            });
            layout.setBody(new Text("Please fill all fields with data, can't add new disc !!!"));
            layout.setActions(oks);
            error.show();
            System.out.println("Brak danych, wpisz je jeszcze raz");
        }
    };
}

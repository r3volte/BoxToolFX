package sample.Controller.Events;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchEvent {
    public Parent roots;

    public void searchDisc() {
        try {
            roots = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/searchDisc.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Search disc");
            stage.setScene(new Scene(roots, 550, 550));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

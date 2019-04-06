package sample.Controller.Events;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddDiscEvents {
    public Parent root;

    public void addDisc() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/adddisc.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add disc to list");
            stage.setScene(new Scene(root, 350, 250));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


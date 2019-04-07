package sample.Controller.Events;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AddDiscEvents {
  public Parent root;
  private static final Logger logger = Logger.getLogger(AddDiscEvents.class.getName());

  public void addDisc() {
    try {
      root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/adddisc.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Add disc to list");
      stage.setScene(new Scene(root, 350, 250));
      stage.show();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
  }
}


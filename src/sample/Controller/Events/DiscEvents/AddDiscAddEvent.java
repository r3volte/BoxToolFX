package sample.Controller.Events.DiscEvents;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Events.AddEvent;


public class AddDiscAddEvent implements AddEvent {
  Parent root;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public void add() {
    try {
      root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/adddisc.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Add disc to list");
      stage.setScene(new Scene(root, 450, 250));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }
}


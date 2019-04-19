package sample.Controller.Events.BoxEvents;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Events.AddEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddBoxAddEvent implements AddEvent {
  Parent root;
  private static final Logger logger = Logger.getLogger(AddBoxAddEvent.class.getName());

  public void add() {
    try {
      root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/addBox.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Add box to list");
      stage.setScene(new Scene(root, 450, 250));
      stage.show();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
  }
}


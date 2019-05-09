package sample.Controller.Events.ConfEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Events.AddEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddConfAddEvent implements AddEvent {
  Parent root;
  private static final Logger logger = Logger.getLogger(AddConfAddEvent.class.getName());

  public void add() {
    try {
      root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/addConfBox.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Add box to configuration");
      stage.setScene(new Scene(root, 450, 324));
      stage.show();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
  }
}


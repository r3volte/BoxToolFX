package sample.Controller.Events.BoxEvents;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Events.AddEvent;


public class AddBoxAddEvent implements AddEvent {
  Parent root;
  private final Logger logger = Logger.getLogger(this.getClass().getName());
  private Stage stage = new Stage();

  public void add() {
    try {
      root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/addBox.fxml"));
      stage.setTitle("Add box to list");
      stage.setScene(new Scene(root, 450, 250));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }

  public void closeWindows() {
    stage.hide();
  }
}


package sample.Controller.Events.ClientEvents;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Events.AddEvent;


public class AddClientAddEvent implements AddEvent {
  Parent root;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public void add() {
    try {
      root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/addClient.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Add client to list");
      stage.setScene(new Scene(root, 625, 285));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }
}


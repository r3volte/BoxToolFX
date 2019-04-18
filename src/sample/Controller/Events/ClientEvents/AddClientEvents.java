package sample.Controller.Events.ClientEvents;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddClientEvents {
  Parent root;
  private static final Logger logger = Logger.getLogger(AddClientEvents.class.getName());

  public void addClient() {
    try {
      root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/addClient.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Add client to list");
      stage.setScene(new Scene(root, 625, 285));
      stage.show();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
  }
}


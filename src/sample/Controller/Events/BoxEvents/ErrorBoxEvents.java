package sample.Controller.Events.BoxEvents;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Events.ErrorEvent;


public class ErrorBoxEvents implements ErrorEvent {

  Parent root;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public void error() {
    try {
      root = FXMLLoader.load(getClass()
              .getClassLoader().getResource("sample/GUI/errorBoxPanel.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Error");
      stage.setScene(new Scene(root, 450, 250));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }
}

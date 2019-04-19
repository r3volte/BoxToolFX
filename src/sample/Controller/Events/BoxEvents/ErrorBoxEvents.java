package sample.Controller.Events.BoxEvents;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Events.DiscEvents.AddDiscAddEvent;
import sample.Controller.Events.ErrorEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ErrorBoxEvents implements ErrorEvent {

  Parent root;
  private static final Logger logger = Logger.getLogger(ErrorBoxEvents.class.getName());

  public void error() {
    try {
      root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/GUI/errorBoxPanel.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Error");
      stage.setScene(new Scene(root, 450, 250));
      stage.show();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
  }
}

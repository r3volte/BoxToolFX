package sample.Controller.Events.DiscEvents;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SearchEvent {
  public Parent roots;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public void searchDisc() {
    try {
      roots = FXMLLoader.load(getClass()
              .getClassLoader()
              .getResource("sample/GUI/searchDisc.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Search disc");
      stage.setScene(new Scene(roots, 735, 355));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }
}

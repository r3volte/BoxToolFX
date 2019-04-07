package sample.Controller.Events;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SearchEvent {
  public Parent roots;
  private static final Logger logger = Logger.getLogger(SearchEvent.class.getName());

  public void searchDisc() {
    try {
      roots = FXMLLoader.load(getClass()
              .getClassLoader()
              .getResource("sample/GUI/searchDisc.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Search disc");
      stage.setScene(new Scene(roots, 550, 550));
      stage.show();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
  }
}

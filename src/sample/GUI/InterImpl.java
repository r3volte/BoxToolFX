package sample.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Application.FileOpe.Writters.*;
import sample.Controller.Controller;

import java.io.IOException;
import java.util.logging.Logger;


public class InterImpl extends Application {

  private final Logger logger = Logger.getLogger(this.getClass().getName());

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("NewWindows.fxml"));
    Controller controller = new Controller();
    FXMLLoader loader = new FXMLLoader();
    loader.setController(controller);
    primaryStage.setTitle("Box Tool 1.0.3");
    primaryStage.setScene(new Scene(root, 1300, 800));
    primaryStage.show();
    primaryStage.setResizable(false);
  }

  @Override
  public void stop() {
    //Save files...
    saveDiscsJSON();
    saveBoxJSON();
    saveClientJSON();
  }

  private void saveDiscsJSON() {
    FileWrite discFileWrite = new DiscFileWrite();
    try {
      discFileWrite.save("discs.json");
    } catch (IOException e) {
      logger.warning("Discs save Error" + e);
    }
  }

  private void saveBoxJSON() {
    FileWrite boxFileWrite = new BoxFileWrite();
    try {
      boxFileWrite.save("box.json");
    } catch (IOException e) {
      logger.warning("Box save Error" + e);
    }
  }

  private void saveClientJSON() {
    FileWrite clientFileWrite = new ClientFileWrite();
    try {
      clientFileWrite.save("clients.json");
    } catch (IOException e) {
      logger.warning("Clients save Error" + e);
    }
  }
}

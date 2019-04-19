package sample.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Application.FileOpe.Writters.*;
import sample.Controller.Controller;

import java.io.IOException;


public class InterImpl extends Application {


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
    DiscFileWrite discFileWrite = new DiscFileWrite();
    try {
      discFileWrite.save("discs.json");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveBoxJSON() {
    BoxFileWrite boxFileWrite = new BoxFileWrite();
    try {
      boxFileWrite.save("box.json");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveClientJSON() {
    ClientFileWrite clientFileWrite = new ClientFileWrite();
    try {
      clientFileWrite.save("clients.json");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

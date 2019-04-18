package sample.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Application.FileOpe.Writters.*;
import sample.Controller.Controller;


public class InterImpl extends Application {


  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("NewWindows.fxml"));
    Controller controller = new Controller();
    FXMLLoader loader = new FXMLLoader();
    loader.setController(controller);
    primaryStage.setTitle("Box Tool 1.2 Alpha");
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
    discFileWrite.save("discs.json");
  }

  private void saveBoxJSON() {
    BoxFileWrite boxFileWrite = new BoxFileWrite();
    boxFileWrite.save("box.json");
  }

  private void saveClientJSON() {
    ClientFileWrite clientFileWrite = new ClientFileWrite();
    clientFileWrite.save("clients.json");
  }
}

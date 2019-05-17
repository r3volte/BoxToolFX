package sample.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Application.Databases.*;
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
    saveJson();
  }

  private void saveJson() {
    DatabaseFileWrite databaseFileWrite;
    databaseFileWrite = new DatabaseFileWrite
            (new InMemoryRepo(new InMemoryClientsDB(), new InMemoryDiscsDB(), new InMemoryBoxDB()));
    try {
      databaseFileWrite.save("box.json", databaseFileWrite.getRepo().getBoxDB().getBox());
      databaseFileWrite.save("clients.json", databaseFileWrite.getRepo().getClientsDB().getClients());
      databaseFileWrite.save("discs.json", databaseFileWrite.getRepo().getDiscsDB().getDiscs());
    } catch (IOException e) {
      logger.warning("Box save Error" + e);
    }
  }

}

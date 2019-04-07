package sample.GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Application.FileOpe.Writters.BoxFileWrite;
import sample.Application.FileOpe.Writters.ClientFileWrite;
import sample.Application.FileOpe.Writters.DiscFileWrite;
import sample.Controller.Controller;


public class InterImpl extends Application {

  private static final Logger logger = Logger.getLogger(InterImpl.class.getName());


  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("boxtool.fxml"));
    Controller controller = new Controller();
    FXMLLoader loader = new FXMLLoader();
    loader.setController(controller);
    primaryStage.setTitle("Box Tool 1.1");
    primaryStage.setScene(new Scene(root, 1100, 700));
    primaryStage.show();

  }

  @Override
  public void stop() {
    logger.log(Level.FINE, "Stage is closing");
    // Save files...
    saveDisc();
    saveBox();
    //saveClients();

  }

  private void saveDisc() {
    DiscFileWrite discWrite = new DiscFileWrite();
    discWrite.save("discs.csv");
  }

  private void saveBox() {
    BoxFileWrite boxWrite = new BoxFileWrite();
    boxWrite.save("box.csv");
  }

  private void saveClients() {
    ClientFileWrite clientWrite = new ClientFileWrite();
    clientWrite.save("clients.csv");
  }
}

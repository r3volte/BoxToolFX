package boxTool.ui.clientFrame;

import boxTool.controllers.AddClientController;
import boxTool.fileResources.Resources;
import boxTool.ui.AddFrame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

@Component(value = "clientFrame")
public class ClientFrame implements AddFrame {

  private Parent root;
  private final Logger logger = Logger.getLogger(this.getClass().getName());
  private FXMLLoader fxmlLoader;
  private Stage stage;
  private final AddClientController addFrame;

  @Autowired
  public ClientFrame(AddClientController addFrame) {
    this.addFrame = addFrame;
  }

  @Override
  public void add() {
    fxmlLoader = new FXMLLoader();
    stage = new Stage();
    try {
      Resources.setLocale();
      ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
      fxmlLoader.setResources(bundle);
      fxmlLoader.setLocation(getClass().getResource(Resources.clientFramePath()));
      fxmlLoader.setController(addFrame);
      root = fxmlLoader.load();
      stage.setTitle("Add box to list");
      stage.setScene(new Scene(root, 625, 285));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }

  public void error() {
    fxmlLoader = new FXMLLoader();
    stage = new Stage();
    try {
      Resources.setLocale();
      ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
      fxmlLoader.setResources(bundle);
      fxmlLoader.setLocation(getClass().getResource(Resources.errorPath()));
      root = fxmlLoader.load();
      stage.setTitle("Error");
      stage.setScene(new Scene(root, 450, 250));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }
}

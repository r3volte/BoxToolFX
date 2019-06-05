package BoxTool.UI.Frames.DiscFrame;

import BoxTool.Controllers.SearchDiscController;
import BoxTool.FileResources.Resources;
import BoxTool.UI.Frames.AddFrame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component(value = "searchFrame")
public class SearchFrame implements AddFrame {

  private Parent root;
  private final Logger logger = Logger.getLogger(this.getClass().getName());
  private FXMLLoader fxmlLoader;
  private Stage stage;
  @Autowired
  private SearchDiscController addFrame;

  @Override
  public void add() {
    fxmlLoader = new FXMLLoader();
    stage = new Stage();
    try {
      fxmlLoader.setLocation(getClass().getResource(Resources.discSearchFramePath()));
      fxmlLoader.setController(addFrame);
      root = fxmlLoader.load();
      stage.setTitle("Search Disc");
      stage.setScene(new Scene(root, 735, 355));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }

  public void error() {
    fxmlLoader = new FXMLLoader();
    stage = new Stage();
    try {
      fxmlLoader.setLocation(getClass().getResource(Resources.discFrameErrorPath()));
      root = fxmlLoader.load();
      stage.setTitle("Error");
      stage.setScene(new Scene(root, 450, 250));
      stage.show();
    } catch (IOException e) {
      logger.info("Error" + e);
    }
  }
}

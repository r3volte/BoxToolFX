package BoxTool;

import BoxTool.FileResources.Resources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BoxToolApplication extends Application {

  private ConfigurableApplicationContext springContext;
  private Parent rootNode;
  private FXMLLoader fxmlLoader;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void init() {
    springContext = SpringApplication.run(BoxToolApplication.class);
    fxmlLoader = new FXMLLoader();
    fxmlLoader.setControllerFactory(springContext::getBean);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    fxmlLoader.setLocation(getClass().getResource(Resources.mainFrame()));
    rootNode = fxmlLoader.load();
    primaryStage.setTitle("Box Tool 1.0.3");
    primaryStage.setScene(new Scene(rootNode, 1300, 800));
    primaryStage.show();
  }

  @Override
  public void stop() {
    springContext.stop();
  }
}

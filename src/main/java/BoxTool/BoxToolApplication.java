package boxTool;

import boxTool.fileResources.Resources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;
import java.util.ResourceBundle;

@Data
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
        Resources.setLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        fxmlLoader.setResources(bundle);
        fxmlLoader.setLocation(getClass().getResource(Resources.mainFrame()));
        rootNode = fxmlLoader.load();
        primaryStage.setTitle(bundle.getString("title.application"));
        primaryStage.setScene(new Scene(rootNode, 1300, 800));
        primaryStage.show();
        primaryStage.getIcons().add(Resources.appIcon());
    }

    @Override
    public void stop() {
        springContext.stop();
    }
}

package boxTool.ui.discFrame;

import boxTool.controllers.SearchDiscController;
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

@Component(value = "searchFrame")
public class SearchFrame implements AddFrame {

    private Parent root;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private FXMLLoader fxmlLoader;
    private Stage stage;
    private final SearchDiscController addFrame;

    @Autowired
    public SearchFrame(SearchDiscController addFrame) {
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
            fxmlLoader.setLocation(getClass().getResource(Resources.discSearchFramePath()));
            fxmlLoader.setController(addFrame);
            root = fxmlLoader.load();
            stage.setTitle("Search Disc");
            stage.setScene(new Scene(root, 735, 355));
            stage.show();
            stage.getIcons().add(Resources.appIcon());
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
            stage.getIcons().add(Resources.appIcon());
        } catch (IOException e) {
            logger.info("Error" + e);
        }
    }
}

package boxTool.ui.confFrame;

import boxTool.controllers.AddConfController;
import boxTool.fileResources.Resources;
import boxTool.ui.AddFrame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component(value = "confFrame")
public class ConfFrame implements AddFrame {

    private Parent root;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private FXMLLoader fxmlLoader;
    private Stage stage;
    private final AddConfController addConfController;

    @Autowired
    public ConfFrame(AddConfController addConfController) {
        this.addConfController = addConfController;
    }

    @Override
    public void add() {
        fxmlLoader = new FXMLLoader();
        stage = new Stage();
        try {
            fxmlLoader.setLocation(getClass().getResource(Resources.confFramePath()));
            fxmlLoader.setController(addConfController);
            root = fxmlLoader.load();
            stage.setTitle("Add configuration to list");
            stage.setScene(new Scene(root, 450, 250));
            stage.show();
        } catch (IOException e) {
            logger.info("Error" + e);
        }
    }

    @Override
    public void error() {

    }
}

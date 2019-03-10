package sample.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Controller;

public class GUI extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("boxtool.fxml"));
        Controller controller = new Controller();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);
        primaryStage.setTitle("Box Tool 1.1");
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();

    }
}

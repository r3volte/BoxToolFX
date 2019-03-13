package sample.GUI;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Application.FileOpe.Writters.DiscWritter;
import sample.Controller.Controller;

import java.io.IOException;


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

    @Override
    public void stop(){
        System.out.println("Stage is closing");
        // Save file
        DiscWritter discWritter = new DiscWritter();
        try {
            discWritter.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }
}

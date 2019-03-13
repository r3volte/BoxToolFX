package sample;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import javafx.application.Application;
import sample.Application.FileOpe.Writters.DiscWritter;
import sample.Application.Threads.RunThreads;
import sample.GUI.GUI;
import java.io.IOException;


public class Main{

    public static void main(String[] args) throws IOException {

        Runnable guiRun = () -> {

            System.out.println("Thread one is running:" +
                    "\n- GUI has been started.");
            Application.launch(GUI.class,args);
        };
        Thread t1 = new Thread(guiRun);
        t1.start();
        RunThreads runThreads = new RunThreads();
        runThreads.runThreads();

    }
}

package sample;

import javafx.application.Application;
import sample.Application.Threads.ReadingFileThread;
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
        ReadingFileThread t2 = new ReadingFileThread();
        t2.threadRun();
    }
}

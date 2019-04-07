package sample;

import javafx.application.Application;
import sample.Application.Selecting.SelectDisc;
import sample.Application.Threads.RunThreads;
import sample.GUI.InterImpl;

public class Main {

  public static void main(String[] args) {

    Runnable guiRun = () -> {

      System.out.println("Thread one is running:"
              + "\n- InterImpl has been started.");
      Application.launch(InterImpl.class, args);
    };
    Thread t1 = new Thread(guiRun);
    t1.start();
    RunThreads runThreads = new RunThreads();
    runThreads.runThreads();

    SelectDisc selectDisc = new SelectDisc();

    selectDisc.selector();
  }
}

package sample.Application.Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

import sample.Application.FileOpe.Readers.BoxReader;


public class ReadBoxFileThread {

  private static final Logger logger = Logger.getLogger(ReadBoxFileThread.class.getName());

  public void threadRun() {
    Runnable runBoxRead = () -> {
      logger.log(Level.FINE, "Third thread is running..."
              + "\n- file read complete.");
      BoxReader readC = new BoxReader();
      readC.readFile("box.csv");
    };
    Thread t3 = new Thread(runBoxRead);
    t3.start();
  }
}

package sample.Application.Threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import sample.Application.FileOpe.Readers.DiscReader;

public class ReadingFileThread {

  private static final Logger logger = Logger.getLogger(ReadingFileThread.class.getName());

  public void threadRun() {
    Runnable runFileRead = () -> {
      logger.log(Level.FINE, "Second thread is running..."
              + "\n- file read complete.");
      DiscReader readC = new DiscReader();
      readC.readFile("discs.csv");
    };
    Thread t2 = new Thread(runFileRead);
    t2.start();
  }
}

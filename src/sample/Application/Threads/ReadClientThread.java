package sample.Application.Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

import sample.Application.FileOpe.Readers.ClientReader;


public class ReadClientThread {

  private static final Logger logger = Logger.getLogger(ReadClientThread.class.getName());

  public void threadRun() {
    Runnable runClientRead = () -> {
      logger.log(Level.FINE, "Fourth thread is running..."
              + "\n- file read complete.");
      ClientReader readC = new ClientReader();
      readC.readFile("clients.csv");
    };
    Thread t4 = new Thread(runClientRead);
    t4.start();
  }
}

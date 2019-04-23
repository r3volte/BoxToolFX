package sample.Application.Threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sample.Application.FileOpe.Readers.BoxFileRead;
import sample.Application.FileOpe.Readers.FileRead;
import sample.Application.FileOpe.Writters.Backups.BackupBoxFileWrite;


public class ReadBoxFileThread {

  private static final Logger logger = Logger.getLogger(ReadBoxFileThread.class.getName());


  public void threadRun() {
    Runnable runBoxRead = () -> {
      FileRead boxFileRead = new BoxFileRead();
      try {
        boxFileRead.readFile("box.json");
      } catch (FileNotFoundException e) {
        logger.log(Level.FINE, "File not found !");
      }
      BackupBoxFileWrite backupBoxFileWrite = new BackupBoxFileWrite();
      try {
        backupBoxFileWrite.save("Backup/backupBox.json");
      } catch (IOException e) {
        logger.log(Level.FINE, "File not found !");
      }
    };
    Thread t3 = new Thread(runBoxRead);
    t3.start();
  }
}

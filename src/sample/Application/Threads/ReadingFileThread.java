package sample.Application.Threads;

import sample.Application.FileOpe.Readers.DiscFileRead;
import sample.Application.FileOpe.Readers.FileRead;
import sample.Application.FileOpe.Writters.Backups.BackupDiscFileWrite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingFileThread {

  private static final Logger logger = Logger.getLogger(ReadingFileThread.class.getName());


  public void threadRun() {
    Runnable runFileRead = () -> {
      FileRead discFileRead = new DiscFileRead();
      try {
        discFileRead.readFile("discs.json");
      } catch (FileNotFoundException e) {
        logger.log(Level.FINE, "File not found !");
      }
      BackupDiscFileWrite backupDiscFileWrite = new BackupDiscFileWrite();
      try {
        backupDiscFileWrite.save("Backup/backupDiscs.json");
      } catch (IOException e) {
        logger.log(Level.FINE, "File not found !");
      }
    };
    Thread t2 = new Thread(runFileRead);
    t2.start();
  }
}

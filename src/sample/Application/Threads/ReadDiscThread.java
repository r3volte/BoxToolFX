package sample.Application.Threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import sample.Application.FileOpe.Readers.DiscFileRead;
import sample.Application.FileOpe.Readers.FileRead;
import sample.Application.FileOpe.Writters.Backups.BackupDiscFileWrite;


public class ReadDiscThread implements FileThread {

  private final Logger logger = Logger.getLogger(this.getClass().getName());


  public void threadRun() {
    Runnable runFileRead = () -> {
      try {
        fileSave();
      } catch (FileNotFoundException e) {
        logger.warning("File not found !");
      }
      try {
        backupFileSave();
      } catch (IOException e) {
        logger.warning("File not found !");
      }
    };
    Thread t2 = new Thread(runFileRead);
    t2.start();
  }

  @Override
  public void fileSave() throws FileNotFoundException {
    FileRead discFileRead = new DiscFileRead();
    discFileRead.databaseReader("discs.json");
  }

  @Override
  public void backupFileSave() throws IOException {
    BackupDiscFileWrite backupDiscFileWrite = new BackupDiscFileWrite();
    backupDiscFileWrite.save("Backup/backupDiscs.json");
  }
}

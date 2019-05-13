package sample.Application.Threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import sample.Application.FileOpe.Readers.BoxFileRead;
import sample.Application.FileOpe.Readers.FileRead;
import sample.Application.FileOpe.Writters.Backups.BackupBoxFileWrite;


public class ReadBoxFileThread implements FileThread {

  private final Logger logger = Logger.getLogger(this.getClass().getName());


  public void threadRun() {
    Runnable runBoxRead = () -> {
      try {
        fileSave();
      } catch (FileNotFoundException e) {
        logger.warning("File not found !" + e);
      }
      try {
        backupFileSave();
      } catch (IOException e) {
        logger.warning("File not found !" + e);
      }
    };
    Thread t3 = new Thread(runBoxRead);
    t3.start();
  }

  public void fileSave() throws FileNotFoundException {
    FileRead boxFileRead = new BoxFileRead();
    boxFileRead.databaseReader("box.json");
  }

  public void backupFileSave() throws IOException {
    BackupBoxFileWrite backupBoxFileWrite = new BackupBoxFileWrite();
    backupBoxFileWrite.save("Backup/backupBox.json");
  }
}

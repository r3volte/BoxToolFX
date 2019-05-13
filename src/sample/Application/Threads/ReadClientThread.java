package sample.Application.Threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import sample.Application.FileOpe.Readers.ClientFileRead;
import sample.Application.FileOpe.Readers.FileRead;
import sample.Application.FileOpe.Writters.Backups.BackupClientFileWrite;


public class ReadClientThread implements FileThread {

  private final Logger logger = Logger.getLogger(this.getClass().getName());


  public void threadRun() {
    Runnable runClientRead = () -> {
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
    Thread t4 = new Thread(runClientRead);
    t4.start();
  }

  @Override
  public void fileSave() throws FileNotFoundException {
    FileRead clientFileRead = new ClientFileRead();
    clientFileRead.databaseReader("clients.json");
  }

  @Override
  public void backupFileSave() throws IOException {
    BackupClientFileWrite backupClientFileWrite = new BackupClientFileWrite();
    backupClientFileWrite.save("Backup/backupClients.json");
  }
}

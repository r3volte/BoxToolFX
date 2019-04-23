package sample.Application.Threads;

import sample.Application.FileOpe.Readers.ClientFileRead;
import sample.Application.FileOpe.Readers.FileRead;
import sample.Application.FileOpe.Writters.Backups.BackupClientFileWrite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadClientThread {

  private static final Logger logger = Logger.getLogger(ReadClientThread.class.getName());


  public void threadRun() {
    Runnable runClientRead = () -> {
      FileRead clientFileRead = new ClientFileRead();
      try {
        clientFileRead.readFile("clients.json");
      } catch (FileNotFoundException e) {
        logger.log(Level.FINE, "File not found !");
      }
      BackupClientFileWrite backupClientFileWrite = new BackupClientFileWrite();
      try {
        backupClientFileWrite.save("Backup/backupClients.json");
      } catch (IOException e) {
        logger.log(Level.FINE, "File not found !");
      }
    };
    Thread t4 = new Thread(runClientRead);
    t4.start();
  }
}

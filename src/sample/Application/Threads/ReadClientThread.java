package sample.Application.Threads;

import sample.Application.FileOpe.Readers.ClientFileRead;
import sample.Application.FileOpe.Writters.Backups.BackupClientFileWrite;


public class ReadClientThread {


  public void threadRun() {
    Runnable runClientRead = () -> {
      ClientFileRead clientFileRead = new ClientFileRead();
      clientFileRead.readFile("clients.json");
      BackupClientFileWrite backupClientFileWrite = new BackupClientFileWrite();
      backupClientFileWrite.save("Backup/backupClients.json");
    };
    Thread t4 = new Thread(runClientRead);
    t4.start();
  }
}

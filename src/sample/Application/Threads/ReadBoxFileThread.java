package sample.Application.Threads;

import sample.Application.FileOpe.Readers.BoxFileRead;
import sample.Application.FileOpe.Writters.Backups.BackupBoxFileWrite;


public class ReadBoxFileThread {


  public void threadRun() {
    Runnable runBoxRead = () -> {
      BoxFileRead boxFileRead = new BoxFileRead();
      boxFileRead.readFile("box.json");
      BackupBoxFileWrite backupBoxFileWrite =new BackupBoxFileWrite();
      backupBoxFileWrite.save("Backup/backupBox.json");
    };
    Thread t3 = new Thread(runBoxRead);
    t3.start();
  }
}

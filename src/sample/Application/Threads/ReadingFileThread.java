package sample.Application.Threads;

import sample.Application.FileOpe.Readers.DiscFileRead;
import sample.Application.FileOpe.Writters.Backups.BackupDiscFileWrite;

public class ReadingFileThread {


  public void threadRun() {
    Runnable runFileRead = () -> {
      DiscFileRead discFileRead = new DiscFileRead();
      discFileRead.readFile("discs.json");
      BackupDiscFileWrite backupDiscFileWrite = new BackupDiscFileWrite();
      backupDiscFileWrite.save("Backup/backupDiscs.json");
    };
    Thread t2 = new Thread(runFileRead);
    t2.start();
  }
}

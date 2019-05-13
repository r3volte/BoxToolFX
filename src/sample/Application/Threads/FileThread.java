package sample.Application.Threads;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileThread {

  void threadRun();

  void fileSave() throws FileNotFoundException;

  void backupFileSave() throws IOException;
}

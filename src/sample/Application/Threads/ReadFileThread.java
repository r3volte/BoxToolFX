package sample.Application.Threads;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

import sample.Application.Databases.InMemoryBoxDB;
import sample.Application.Databases.InMemoryClientsDB;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.Databases.InMemoryRepo;
import sample.Application.FileOpe.Readers.DatabaseFileRead;


public class ReadFileThread {

  private final Logger logger = Logger.getLogger(this.getClass().getName());


  public void threadRun() {
    Runnable runBoxRead = () -> {
      try {
        fileLoad();
      } catch (FileNotFoundException e) {
        logger.warning("File not found !" + e);
      }
    };
    Thread t3 = new Thread(runBoxRead);
    t3.start();
  }

  public void fileLoad() throws FileNotFoundException {
    DatabaseFileRead read = new DatabaseFileRead(new InMemoryRepo(new InMemoryClientsDB(), new InMemoryDiscsDB(), new InMemoryBoxDB()));
    read.databaseBoxReader("box.json", read.getRepo().getBoxDB().getBox());
    read.databaseDiscReader("discs.json", read.getRepo().getDiscsDB().getDiscs());
    read.databaseClientReader("clients.json", read.getRepo().getClientsDB().getClients());
  }
}

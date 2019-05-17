package sample.Application.FileOpe.Writters.Backups;

import sample.Application.Databases.InMemoryRepo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DatabaseFileWriteBackup {

  private InMemoryRepo repo;

  public DatabaseFileWriteBackup(InMemoryRepo repo) {
    this.repo = repo;
  }

  public InMemoryRepo getRepo() {
    return repo;
  }

  public void save(String fileOut, List list) throws IOException {
    FileWriter file = new FileWriter(fileOut);
    file.write(repo.fileConverter(list));
    file.flush();
  }
}

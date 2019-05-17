package sample.Application.FileOpe.Writters;

import java.io.FileWriter;

import java.io.IOException;
import java.util.List;

import sample.Application.Databases.InMemoryRepo;

public class DatabaseFileWrite {

  private InMemoryRepo repo;

  public DatabaseFileWrite(InMemoryRepo repo) {
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

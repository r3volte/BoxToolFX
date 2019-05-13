package sample.Application.FileOpe.Writters.Backups;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.FileOpe.Writters.FileWrite;


public class BackupDiscFileWrite implements FileWrite {

  private InMemoryDiscsDB inMemoryDiscsDB = new InMemoryDiscsDB();


  @Override
  public void save(String fileOut) throws IOException {
    FileWriter file = new FileWriter(fileOut);
    file.write(fileConverter());
    file.flush();
  }

  private String fileConverter() {
    return new Gson().toJson(inMemoryDiscsDB.getDiscs());
  }
}

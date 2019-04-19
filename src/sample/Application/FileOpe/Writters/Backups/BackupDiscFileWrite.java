package sample.Application.FileOpe.Writters.Backups;

import com.google.gson.Gson;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.FileOpe.Writters.FileWrite;

import java.io.FileWriter;
import java.io.IOException;

public class BackupDiscFileWrite implements FileWrite {

  private InMemoryDiscsDB inMemoryDiscsDB = new InMemoryDiscsDB();


  @Override
  public void save(String fileOut) throws IOException {
    String jsonFromList = new Gson().toJson(inMemoryDiscsDB.getDiscs());
    FileWriter file = new FileWriter(fileOut);
    file.write(jsonFromList);
    file.flush();
  }
}

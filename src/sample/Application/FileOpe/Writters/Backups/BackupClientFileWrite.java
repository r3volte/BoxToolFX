package sample.Application.FileOpe.Writters.Backups;

import com.google.gson.Gson;
import sample.Application.Databases.InMemoryClientsDB;
import sample.Application.FileOpe.Writters.FileWrite;

import java.io.FileWriter;
import java.io.IOException;


public class BackupClientFileWrite implements FileWrite {

  private InMemoryClientsDB inMemoryClientsDB = new InMemoryClientsDB();


  @Override
  public void save(String fileOut) throws IOException {
    String jsonFromList = new Gson().toJson(inMemoryClientsDB.getClients());
    FileWriter file = new FileWriter(fileOut);
    file.write(jsonFromList);
    file.flush();
  }
}

package sample.Application.FileOpe.Writters.Backups;

import com.google.gson.Gson;
import sample.Application.Databases.InMemoryBoxDB;
import sample.Application.FileOpe.Writters.FileWrite;

import java.io.FileWriter;
import java.io.IOException;



public class BackupBoxFileWrite implements FileWrite {

  private InMemoryBoxDB inMemoryBoxDB = new InMemoryBoxDB();


  @Override
  public void save(String fileOut) throws IOException {
    String jsonFromList = new Gson().toJson(inMemoryBoxDB.getBox());
    FileWriter file = new FileWriter(fileOut);
    file.write(jsonFromList);
    file.flush();
  }
}

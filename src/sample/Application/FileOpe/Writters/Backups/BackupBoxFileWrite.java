package sample.Application.FileOpe.Writters.Backups;

import com.google.gson.Gson;
import sample.Application.Databases.InMemoryBoxDB;
import sample.Application.FileOpe.Writters.FileWrite;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackupBoxFileWrite implements FileWrite {

  private InMemoryBoxDB inMemoryBoxDB = new InMemoryBoxDB();
  private static final Logger logger = Logger.getLogger(BackupBoxFileWrite.class.getName());


  @Override
  public void save(String fileOut) {
    String jsonFromList = new Gson().toJson(inMemoryBoxDB.getBox());
    try (FileWriter file = new FileWriter(fileOut)) {
      file.write(jsonFromList);
      file.flush();
    } catch (IOException e) {
      logger.log(Level.FINE, "File not found !");
    }
  }
}

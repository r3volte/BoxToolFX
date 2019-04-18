package sample.Application.FileOpe.Writters.Backups;

import com.google.gson.Gson;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.FileOpe.Writters.FileWrite;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackupDiscFileWrite implements FileWrite {

  private InMemoryDiscsDB inMemoryDiscsDB = new InMemoryDiscsDB();
  private static final Logger logger = Logger.getLogger(BackupDiscFileWrite.class.getName());


  @Override
  public void save(String fileOut) {
    String jsonFromList = new Gson().toJson(inMemoryDiscsDB.getDiscs());
    try (FileWriter file = new FileWriter(fileOut)) {
      file.write(jsonFromList);
      file.flush();
    } catch (IOException e) {
      logger.log(Level.FINE, "File not found !");
    }
  }
}

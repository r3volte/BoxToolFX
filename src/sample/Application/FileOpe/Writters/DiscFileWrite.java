package sample.Application.FileOpe.Writters;

import com.google.gson.Gson;
import sample.Application.Databases.InMemoryDiscsDB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscFileWrite implements FileWrite {

  private InMemoryDiscsDB inMemoryDiscsDB = new InMemoryDiscsDB();
  private static final Logger logger = Logger.getLogger(DiscFileWrite.class.getName());


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

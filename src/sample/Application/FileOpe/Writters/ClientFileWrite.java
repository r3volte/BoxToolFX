package sample.Application.FileOpe.Writters;

import com.google.gson.Gson;
import sample.Application.Databases.InMemoryClientsDB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientFileWrite implements FileWrite {

  private InMemoryClientsDB inMemoryClientsDB = new InMemoryClientsDB();
  private static final Logger logger = Logger.getLogger(ClientFileWrite.class.getName());

  @Override
  public void save(String fileOut) {
    String jsonFromList = new Gson().toJson(inMemoryClientsDB.getClients());
    try (FileWriter file = new FileWriter(fileOut)) {
      file.write(jsonFromList);
      file.flush();
    } catch (IOException e) {
      logger.log(Level.FINE, "File not found !");
    }
  }
}

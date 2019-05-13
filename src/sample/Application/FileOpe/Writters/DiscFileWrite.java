package sample.Application.FileOpe.Writters;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

import sample.Application.Databases.InMemoryDiscsDB;


public class DiscFileWrite implements FileWrite {

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

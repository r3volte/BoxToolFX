package sample.Application.FileOpe.Writters;

import com.google.gson.Gson;

import java.io.FileWriter;

import java.io.IOException;

import sample.Application.Databases.InMemoryBoxDB;

public class BoxFileWrite implements FileWrite {

  private InMemoryBoxDB inMemoryBoxDB = new InMemoryBoxDB();


  @Override
  public void save(String fileOut) throws IOException {
    FileWriter file = new FileWriter(fileOut);
    file.write(fileConverter());
    file.flush();
  }

  private String fileConverter() {
    return new Gson().toJson(inMemoryBoxDB.getBox());
  }
}

package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.Application.Data.Configurations;
import sample.Application.Databases.InMemoryConfDB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;


public class ConfFileRead implements FileRead {

  private Gson gson = new Gson();
  private InMemoryConfDB inMemoryConfDB = new InMemoryConfDB();

  @Override
  public void databaseReader(String fileIn) throws FileNotFoundException {
    ArrayList<Configurations> tempList = gson.fromJson(readFile(fileIn), listType());
    inMemoryConfDB.getConf().addAll(Collections.singleton(tempList));
  }

  private FileReader readFile(String fileIn) throws FileNotFoundException {
    return new FileReader(fileIn);
  }

  private Type listType() {
    return new TypeToken<ArrayList<Configurations>>() {
    }.getType();
  }
}

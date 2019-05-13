package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Logger;

import sample.Application.Data.Box;
import sample.Application.Databases.InMemoryBoxDB;


public class BoxFileRead implements FileRead {

  private InMemoryBoxDB inMemoryBoxDB = new InMemoryBoxDB();
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  @Override
  public void databaseReader(String fileIn) throws FileNotFoundException {
    ArrayList<Box> tempList = new Gson().fromJson(readFile(fileIn), listType());
    inMemoryBoxDB.getBox().addAll(tempList);
    logger.info("Box database read successfully");
  }

  private FileReader readFile(String fileIn) throws FileNotFoundException {
    return new FileReader(fileIn);
  }

  private Type listType() {
    return new TypeToken<ArrayList<Box>>() {
    }.getType();
  }

}

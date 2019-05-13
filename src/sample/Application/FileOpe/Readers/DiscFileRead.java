package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.lang.reflect.Type;

import java.util.ArrayList;

import java.util.logging.Logger;

import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;


public class DiscFileRead implements FileRead {

  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();
  private final Logger logger = Logger.getLogger(this.getClass().getName());


  @Override
  public void databaseReader(String fileIn) throws FileNotFoundException {
    ArrayList<Discs> tempList = new Gson().fromJson(readFile(fileIn), listType());
    discsDB.getDiscs().addAll(tempList);
    logger.info("Disc database read successfully");
  }

  private FileReader readFile(String fileIn) throws FileNotFoundException {
    return new FileReader(fileIn);
  }

  private Type listType() {
    return new TypeToken<ArrayList<Discs>>() {
    }.getType();
  }
}

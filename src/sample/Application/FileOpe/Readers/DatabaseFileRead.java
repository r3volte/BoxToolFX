package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import sample.Application.Data.Box;
import sample.Application.Data.Clients;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryRepo;


public class DatabaseFileRead {

  private InMemoryRepo repo;
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public DatabaseFileRead(InMemoryRepo repo) {
    this.repo = repo;
  }

  public InMemoryRepo getRepo() {
    return repo;
  }

  public void databaseBoxReader(String fileIn, List<Box> list) throws FileNotFoundException {
    ArrayList<Box> tempList = new Gson().fromJson(readFile(fileIn), listTypeBox());
    list.addAll(tempList);
    logger.info("Box database read successfully");
  }

  public void databaseDiscReader(String fileIn, List<Discs> list) throws FileNotFoundException {
    ArrayList<Discs> tempList = new Gson().fromJson(readFile(fileIn), listTypeDisc());
    list.addAll(tempList);
    logger.info("Box database read successfully");
  }

  public void databaseClientReader(String fileIn, List<Clients> list) throws FileNotFoundException {
    ArrayList<Clients> tempList = new Gson().fromJson(readFile(fileIn), listTypeClient());
    list.addAll(tempList);
    logger.info("Box database read successfully");
  }

  private FileReader readFile(String fileIn) throws FileNotFoundException {
    return new FileReader(fileIn);
  }

  private Type listTypeBox() {
    return new TypeToken<ArrayList<Box>>() {
    }.getType();
  }

  private Type listTypeDisc() {
    return new TypeToken<ArrayList<Discs>>() {
    }.getType();
  }

  private Type listTypeClient() {
    return new TypeToken<ArrayList<Clients>>() {
    }.getType();
  }

}

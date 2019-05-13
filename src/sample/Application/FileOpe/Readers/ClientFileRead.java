package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Logger;

import sample.Application.Data.Clients;
import sample.Application.Databases.InMemoryClientsDB;


public class ClientFileRead implements FileRead {

  private InMemoryClientsDB inMemoryClientsDB = new InMemoryClientsDB();
  private final Logger logger = Logger.getLogger(this.getClass().getName());


  @Override
  public void databaseReader(String fileIn) throws FileNotFoundException {
    ArrayList<Clients> tempList = new Gson().fromJson(readFile(fileIn), listType());
    inMemoryClientsDB.getClients().addAll(tempList);
    logger.info("Clients database read successfully");
  }

  private FileReader readFile(String fileIn) throws FileNotFoundException {
    return new FileReader(fileIn);
  }

  private Type listType() {
    return new TypeToken<ArrayList<Clients>>() {
    }.getType();
  }
}

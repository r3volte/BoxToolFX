package sample.Application.FileOpe.Readers;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.Application.Data.Clients;
import sample.Application.Databases.InMemoryClientsDB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientFileRead implements FileRead {

  private Gson gson = new Gson();
  private static final Logger logger = Logger.getLogger(ClientFileRead.class.getName());
  private InMemoryClientsDB inMemoryClientsDB = new InMemoryClientsDB();


  @Override
  public void readFile(String fileIn) {
    FileReader fileReader = null; //reading json file.
    try {
      fileReader = new FileReader(fileIn);
    } catch (FileNotFoundException e) {
      logger.log(Level.FINE, "File not found !");
    }

    Type listType = new TypeToken<ArrayList<Clients>>() {
    }.getType();

    ArrayList<Clients> tempList = gson.fromJson(fileReader, listType);
    inMemoryClientsDB.getClients().addAll(tempList);
    System.out.println(inMemoryClientsDB.getClients());
    System.out.println(tempList);
  }
}

package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.Application.Data.Clients;
import sample.Application.Databases.InMemoryClientsDB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ClientFileRead implements FileRead {

  private Gson gson = new Gson();
  private InMemoryClientsDB inMemoryClientsDB = new InMemoryClientsDB();


  @Override
  public void readFile(String fileIn) throws FileNotFoundException {
    FileReader fileReader; //reading json file.
    fileReader = new FileReader(fileIn);
    Type listType = new TypeToken<ArrayList<Clients>>() {
    }.getType();

    ArrayList<Clients> tempList = gson.fromJson(fileReader, listType);
    inMemoryClientsDB.getClients().addAll(tempList);
    System.out.println(inMemoryClientsDB.getClients());
    System.out.println(tempList);
  }
}

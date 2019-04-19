package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DiscFileRead implements FileRead {

  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();
  private Gson gson = new Gson();


  @Override
  public void readFile(String fileIn) throws FileNotFoundException {
    FileReader fileReader; //reading json file.
    fileReader = new FileReader(fileIn);

    Type listType = new TypeToken<ArrayList<Discs>>() {
    }.getType();

    ArrayList<Discs> tempList = gson.fromJson(fileReader, listType);
    discsDB.getDiscs().addAll(tempList);
    System.out.println(discsDB.getDiscs());
    System.out.println(tempList);
  }
}

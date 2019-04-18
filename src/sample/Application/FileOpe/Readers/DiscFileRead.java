package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscFileRead implements FileRead {

  private static final Logger logger = Logger.getLogger(DiscFileRead.class.getName());
  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();
  private Gson gson = new Gson();


  @Override
  public void readFile(String fileIn){
    FileReader fileReader = null; //reading json file.
    try {
      fileReader = new FileReader(fileIn);
    } catch (FileNotFoundException e) {
      logger.log(Level.FINE, "File not found !");
    }

    Type listType = new TypeToken<ArrayList<Discs>>() {}.getType();

    ArrayList<Discs> tempList = gson.fromJson(fileReader, listType);
    discsDB.getDiscs().addAll(tempList);
    System.out.println(discsDB.getDiscs());
    System.out.println(tempList);
  }
}

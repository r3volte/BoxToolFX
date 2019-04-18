package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.Application.Data.Box;
import sample.Application.Databases.InMemoryBoxDB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoxFileRead implements FileRead {

  private Gson gson = new Gson();
  private InMemoryBoxDB inMemoryBoxDB = new InMemoryBoxDB();

  private static final Logger logger = Logger.getLogger(BoxFileRead.class.getName());

  @Override
  public void readFile(String fileIn) {
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(fileIn);
    } catch (FileNotFoundException e) {
      logger.log(Level.FINE, "File not found !");
    }

    Type listType = new TypeToken<ArrayList<Box>>() {}.getType();

    ArrayList<Box> tempList = gson.fromJson(fileReader, listType);
    inMemoryBoxDB.getBox().addAll(tempList);
    System.out.println(inMemoryBoxDB.getBox());
    System.out.println(tempList);
  }
}

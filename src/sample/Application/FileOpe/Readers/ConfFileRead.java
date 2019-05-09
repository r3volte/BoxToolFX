package sample.Application.FileOpe.Readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sample.Application.Data.Box;
import sample.Application.Databases.InMemoryBoxDB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class ConfFileRead implements FileRead {

  private Gson gson = new Gson();
  private InMemoryBoxDB inMemoryBoxDB = new InMemoryBoxDB();

  @Override
  public void readFile(String fileIn) throws FileNotFoundException {
    FileReader fileReader;
    fileReader = new FileReader(fileIn);
    Type listType = new TypeToken<ArrayList<Box>>() {}.getType();
    ArrayList<Box> tempList = gson.fromJson(fileReader, listType);
    inMemoryBoxDB.getBox().addAll(tempList);
    System.out.println(inMemoryBoxDB.getBox());
    System.out.println(tempList);
  }
}

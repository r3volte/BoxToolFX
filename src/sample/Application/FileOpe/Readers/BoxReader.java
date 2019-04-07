package sample.Application.FileOpe.Readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sample.Application.Data.Box;
import sample.Application.Databases.InMemoryBoxDB;

public class BoxReader implements FileRead {

  private static final Logger logger = Logger.getLogger(BoxReader.class.getName());
  private String emptyLine = null;
  private InMemoryBoxDB boxDB = new InMemoryBoxDB();


  @Override
  public void readFile(String fileIn) {
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(fileIn);
    } catch (FileNotFoundException e) {
      logger.log(Level.FINE, "File not found. Please restart program!");
    }
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    while (true) {
      try {
        if ((emptyLine = bufferedReader.readLine()) == null) {
          break;
        }
      } catch (IOException e) {
        logger.log(Level.SEVERE, e.toString(), e);
      }

      String[] temp = emptyLine.split(",");
      int number = Integer.parseInt(temp[0]);
      int width = Integer.parseInt(temp[1]);
      int height = Integer.parseInt(temp[2]);

      boxDB.getBox().add(new Box(number, width, height));
    }
    try {
      bufferedReader.close();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
    boxDB.showDB();
  }
}

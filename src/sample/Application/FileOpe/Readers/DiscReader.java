package sample.Application.FileOpe.Readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;

public class DiscReader implements FileRead {

  private static final Logger logger = Logger.getLogger(FileRead.class.getName());
  private String emptyLine = null;
  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();


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
      double diameter = Double.parseDouble(temp[1]);
      double height = Double.parseDouble(temp[2]);
      double heightX2 = Double.parseDouble(temp[3]);
      double weight = Double.parseDouble(temp[4]);
      discsDB.getDiscs().add(new Discs(number, diameter, height, heightX2, weight));
    }
    try {
      bufferedReader.close();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
    discsDB.showDB();
    System.out.println(discsDB.getDiscs().size());
  }
}

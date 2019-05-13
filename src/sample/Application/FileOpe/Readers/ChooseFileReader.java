package sample.Application.FileOpe.Readers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.stage.FileChooser;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.Selecting.SelectDisc;


public class ChooseFileReader {


  private SelectDisc selectDisc = new SelectDisc();

  private File fileChooser() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt file", "*.txt"));
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      System.out.println(file.getAbsoluteFile());
    }
    return file;
  }

  public List<Discs> fileReader(InMemoryDiscsDB discsDB) throws IOException {
    Scanner scanner = new Scanner(fileChooser());
    List<Discs> tempList = new ArrayList<>();
    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        tempList.addAll(selectDisc.searchDisc(discsDB.getDiscs(), scanner.nextInt()));
      } else {
        scanner.next();
      }
    }
    return tempList;
  }

}

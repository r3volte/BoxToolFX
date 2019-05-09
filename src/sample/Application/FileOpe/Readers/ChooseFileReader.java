package sample.Application.FileOpe.Readers;

import javafx.stage.FileChooser;
import sample.Application.Data.Box;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryBoxDB;
import sample.Application.Databases.InMemoryDiscsDB;
import sample.Application.Selecting.BoxSelector;
import sample.Application.Selecting.SelectDisc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChooseFileReader {


  private SelectDisc selectDisc = new SelectDisc();
  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();

  private File fileChooser() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt file", "*.txt"));
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      System.out.println(file.getAbsoluteFile());
    }
    return file;
  }

  public List<Discs> fileReader() throws IOException {
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

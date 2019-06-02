package BoxTool.DatabaseOperations.Read;

import BoxTool.Data.Discs;
import BoxTool.Repository.DataRepository;
import BoxTool.Repository.DiscRepository;
import BoxTool.Selector.SelectDisc;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ChooseFileReader {

  @Autowired
  private SelectDisc selectDisc;


  public List<Discs> fileReader(DataRepository discsDB) throws IOException {
    Scanner scanner = new Scanner(fileChooser());
    List<Discs> tempList = new ArrayList<>();
    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        tempList.addAll(selectDisc
                .searchDisc(discsDB
                        .getComponent(), scanner.nextInt()));
      } else {
        scanner.next();
      }
    }
    return tempList;
  }

  //metoda do wybierania pliku txt ze wskazanej lokacji,ktory nastepnie jest zwracany jako File
  private File fileChooser() {
    FileChooser fileChooser = getFileChooser();
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      System.out.println(file.getAbsoluteFile());
    }
    return file;
  }

  private FileChooser getFileChooser() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters()
            .add(new FileChooser.ExtensionFilter("Txt file", "*.txt"));
    return fileChooser;
  }
}

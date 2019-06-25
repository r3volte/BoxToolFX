package boxTool.databaseOperations.read;

import boxTool.data.Discs;
import boxTool.selector.SelectDisc;
import boxTool.services.DatabaseDiscService;
import javafx.stage.FileChooser;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Component
public class ChooseFileReader {

  private final Logger logger = Logger.getLogger(this.getClass().getName());


  public List<Discs> fileReader(SelectDisc selectDisc, DatabaseDiscService discsDB) throws IOException {
    Scanner scanner = new Scanner(fileChooser());
    List<Discs> tempList = new ArrayList<>();
    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        tempList.addAll(selectDisc
                .searchDisc(discsDB.getData(), scanner.nextInt()));
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
      logger.info((Supplier<String>) file.getAbsoluteFile());
    }
    return file;
  }

  private FileChooser getFileChooser() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters()
            .add(new FileChooser
                    .ExtensionFilter("Txt file", "*.txt"));
    return fileChooser;
  }
}

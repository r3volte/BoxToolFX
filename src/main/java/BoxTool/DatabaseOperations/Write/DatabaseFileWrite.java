package BoxTool.DatabaseOperations.Write;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class DatabaseFileWrite {


  public void save(String fileOut, String list) throws IOException {
    FileWriter file = new FileWriter(fileOut);
    file.write(list);
    file.flush();
  }
}

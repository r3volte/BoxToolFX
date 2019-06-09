package BoxTool.DatabaseOperations.Read;

import BoxTool.Data.Box;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class DatabaseFileRead {

  private final Logger logger = Logger.getLogger(this.getClass().getName());

  public void databaseReader(String fileIn, List list, Type type) throws FileNotFoundException {
    ArrayList tempList = new Gson().fromJson(readFile(fileIn), type);
    list.addAll(tempList);
    logger.info("Database read successfully");
  }

  public void databaseConfReader(String fileIn, Map<String, List<Box>> list, Type type) throws FileNotFoundException {
    HashMap<String, List<Box>> tempList = new Gson().fromJson(readFile(fileIn), type);
    list.putAll(tempList);
    logger.info("Configuration database read successfully");
  }

  protected FileReader readFile(String fileIn) throws FileNotFoundException {
    return new FileReader(fileIn);
  }

}

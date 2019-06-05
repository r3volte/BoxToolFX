package BoxTool.DatabaseOperations.Read;

import BoxTool.Data.Box;
import BoxTool.DatabaseOperations.ListType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseFileReadTest {

  public static String fileIn;
  public static List myList = new ArrayList<>();

  @BeforeClass
  public static void beforeClass() {
    fileIn = "src\\main\\resources\\json\\box.json";
  }

  @Test
  public void shouldBeFileRead() {
    DatabaseFileRead read = new DatabaseFileRead();
    assertThrows(FileNotFoundException.class, () -> read.readFile(""));
  }

  @Test
  public void shouldReadDatabase() throws FileNotFoundException {
    DatabaseFileRead read = new DatabaseFileRead();
    read.databaseReader(fileIn, myList, ListType.listBox());
    assertFalse(myList.isEmpty());
  }

  @Test
  public void shouldReadConf() throws FileNotFoundException {
    DatabaseFileRead read = new DatabaseFileRead();
    Map<String, List<Box>> map = new HashMap<>();
    read.databaseConfReader("",map, ListType.listTypeConf());
  }
}

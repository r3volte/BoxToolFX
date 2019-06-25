package boxTool.databaseOperations.write;

import boxTool.data.Box;
import boxTool.repository.BoxRepository;
import boxTool.repository.DataRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseFileWriteTest {

  public static List temp = new ArrayList();
  public static DataRepository boxRepository;
  public static File file = new File("test.json");

  @BeforeClass
  public static void before() {
    Box box = new Box(200, 230, 90);
    temp.add(box);
    boxRepository = new BoxRepository();
  }
  @AfterAll
  public static void after() throws IOException {
    Files.deleteIfExists(Paths.get("test.json"));
  }

  @Test
  public void shouldSaveFile() throws IOException {
    DatabaseFileWrite databaseFileWrite = new DatabaseFileWrite();
    databaseFileWrite.save("test.json", boxRepository.fileConverter(temp));
    Scanner sc = new Scanner(file);
    Assertions.assertTrue(sc.hasNextLine());
  }
}

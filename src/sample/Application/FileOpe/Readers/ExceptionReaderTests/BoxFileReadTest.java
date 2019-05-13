package sample.Application.FileOpe.Readers.ExceptionReaderTests;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Readers.BoxFileRead;

class BoxFileReadTest {

  private BoxFileRead boxFileRead;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(FileNotFoundException.class, () -> {
      String name = ".json";
      boxFileRead = new BoxFileRead();
      boxFileRead.databaseReader(name);
    });
  }
}
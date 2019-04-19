package sample.Application.FileOpe.Readers.ExceptionReaderTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Readers.BoxFileRead;

import java.io.FileNotFoundException;

class BoxFileReadTest {

  private BoxFileRead boxFileRead;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(FileNotFoundException.class, () -> {
      String name = ".json";
      boxFileRead = new BoxFileRead();
      boxFileRead.readFile(name);
    });
  }
}
package sample.Application.FileOpe.Readers.ExceptionReaderTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Readers.DiscFileRead;

import java.io.FileNotFoundException;

class DiscFileReadTest {

  private DiscFileRead discFileRead;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(FileNotFoundException.class, () -> {
      String name = ".json";
      discFileRead = new DiscFileRead();
      discFileRead.readFile(name);
    });
  }
}
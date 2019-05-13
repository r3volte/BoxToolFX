package sample.Application.FileOpe.Readers.ExceptionReaderTests;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Readers.DiscFileRead;


class DiscFileReadTest {

  private DiscFileRead discFileRead;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(FileNotFoundException.class, () -> {
      String name = ".json";
      discFileRead = new DiscFileRead();
      discFileRead.databaseReader(name);
    });
  }
}
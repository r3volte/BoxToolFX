package sample.Application.FileOpe.Readers.ExceptionReaderTests;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Readers.ClientFileRead;


class ClientFileReadTest {

  private ClientFileRead clientFileRead;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(FileNotFoundException.class, () -> {
      String name = ".json";
      clientFileRead = new ClientFileRead();
      clientFileRead.databaseReader(name);
    });
  }
}
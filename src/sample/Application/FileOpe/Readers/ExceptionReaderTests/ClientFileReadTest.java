package sample.Application.FileOpe.Readers.ExceptionReaderTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Readers.ClientFileRead;

import java.io.FileNotFoundException;

class ClientFileReadTest {

  private ClientFileRead clientFileRead;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(FileNotFoundException.class, () -> {
      String name = ".json";
      clientFileRead = new ClientFileRead();
      clientFileRead.readFile(name);
    });
  }
}
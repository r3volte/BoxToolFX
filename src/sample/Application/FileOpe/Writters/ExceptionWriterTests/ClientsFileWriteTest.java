package sample.Application.FileOpe.Writters.ExceptionWriterTests;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Writters.ClientFileWrite;

class ClientsFileWriteTest {

  private ClientFileWrite clientFileWrite;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(IOException.class, () -> {
      String name = "";
      clientFileWrite = new ClientFileWrite();
      clientFileWrite.save(name);
    });
  }
}
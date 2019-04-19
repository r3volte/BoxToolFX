package sample.Application.FileOpe.Writters.ExceptionWriterTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Writters.BoxFileWrite;

import java.io.IOException;

class BoxFileWriteTest {

  private BoxFileWrite boxFileWrite;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(IOException.class, () -> {
      String name = "";
      boxFileWrite = new BoxFileWrite();
      boxFileWrite.save(name);
    });
  }
}
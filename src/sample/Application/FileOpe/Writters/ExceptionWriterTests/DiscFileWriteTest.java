package sample.Application.FileOpe.Writters.ExceptionWriterTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Application.FileOpe.Writters.DiscFileWrite;

import java.io.IOException;

class DiscFileWriteTest {

  private DiscFileWrite discFileWrite;

  @Test
  public void shouldBeFileNotFoundExceptionTest() {
    Assertions.assertThrows(IOException.class, () -> {
      String name = "";
      discFileWrite = new DiscFileWrite();
      discFileWrite.save(name);
    });
  }
}
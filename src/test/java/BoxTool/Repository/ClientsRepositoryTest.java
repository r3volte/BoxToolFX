package boxTool.repository;

import boxTool.data.Clients;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientsRepositoryTest {



  @Test
  public void shouldBeJSonException() {
    DataRepository repo = new ClientRepository();
    List<Clients> myList = new ArrayList<>();
    repo.fileConverter(myList);
    assertThrows(JSONException.class, () -> JSONAssert
            .assertEquals("", repo.fileConverter(myList), true));
  }
}

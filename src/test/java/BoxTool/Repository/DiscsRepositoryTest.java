package boxTool.repository;

import boxTool.data.Discs;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiscsRepositoryTest {


  @Test
  public void shouldAddBoxToList() {
    DataRepository discRepo = new DiscRepository();
    List<Discs> beforeAdd = new ArrayList<>();
    Discs discs = new Discs(201011, 300.0, 40.3, 80.6, 5.3);
    discRepo.add(discs);
    assertEquals(beforeAdd.size() + 1, discRepo.getComponent().size());
  }

  @Test
  public void shouldRemoveBoxFromList() {
    DataRepository discRepo = new DiscRepository();
    List<Discs> afterRemove = new ArrayList<>();
    Discs discs = new Discs(201011, 300.0, 40.3, 80.6, 5.3);
    discRepo.delete(discs);
    assertEquals(afterRemove.size(), discRepo.getComponent().size());
  }

  @Test
  public void shouldBeJSonException() {
    DataRepository repo = new DiscRepository();
    List<Discs> myList = new ArrayList<>();
    repo.fileConverter(myList);
    assertThrows(JSONException.class, () -> JSONAssert
            .assertEquals("", repo.fileConverter(myList), true));
  }

  @Test
  public void shouldGetConvertedJSon() throws JSONException {
    DataRepository repo = new BoxRepository();
    Discs discs = new Discs(201011, 300.0, 40.3, 80.6, 5.3);
    List<Discs> myList = new ArrayList<>();
    myList.add(discs);
    repo.fileConverter(myList);
    JSONAssert.assertEquals("[{\"number\":201011,\"diameter\":300.0,\"height\":40.3, \"height2\":80.6, \"weight\":5.3}]", repo.fileConverter(myList), true);
    JSONAssert.assertEquals("[{\"diameter\":300.0,\"number\":201011,\"height\":40.3, \"height2\":80.6, \"weight\":5.3}]", repo.fileConverter(myList), false);
  }

}

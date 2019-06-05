package BoxTool.Repository;

import BoxTool.Data.Clients;
import BoxTool.Data.MountInstruction;
import BoxTool.Data.PcsPerBox;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientsRepositoryTest {


  @Test
  public void shouldAddClientsToList() {
    DataRepository clientRepo = new ClientRepository();
    List<Clients> beforeAdd = new ArrayList<>();
    Clients clients = new Clients(12, "NK", "NK", PcsPerBox.ONE,
            "NK", PcsPerBox.ONE, "NK", PcsPerBox.ONE, MountInstruction.YES);
    clientRepo.add(clients);
    assertEquals(beforeAdd.size() + 1, clientRepo.getComponent().size());
  }

  @Test
  public void shouldRemoveBoxFromList() {
    DataRepository clientRepo = new ClientRepository();
    List<Clients> afterRemove = new ArrayList<>();
    Clients clients = new Clients(12, "NK", "NK", PcsPerBox.ONE,
            "NK", PcsPerBox.ONE, "NK", PcsPerBox.ONE, MountInstruction.YES);
    clientRepo.getComponent().add(clients);
    clientRepo.delete(clients);
    assertEquals(afterRemove.size(), clientRepo.getComponent().size());
  }

  @Test
  public void shouldBeJSonException() {
    DataRepository repo = new ClientRepository();
    List<Clients> myList = new ArrayList<>();
    repo.fileConverter(myList);
    assertThrows(JSONException.class, () -> JSONAssert
            .assertEquals("", repo.fileConverter(myList), true));
  }
}

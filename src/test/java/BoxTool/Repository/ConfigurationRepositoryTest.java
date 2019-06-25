package boxTool.repository;

import boxTool.data.Configurations;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConfigurationRepositoryTest {


  @Test
  public void shouldAddBoxToList() {
    ConfigurationsRepository confRepo = new ConfigurationsRepository();
    Map<String, Configurations> beforeAdd = new HashMap<>();
    confRepo.add("NK", 325, 270, 115);
    assertEquals(beforeAdd.size() + 1, confRepo.getComponent().size());
  }

  @Test
  public void shouldBeJSonException() {
    ConfigurationsRepository repo = new ConfigurationsRepository();
    Map<String, Configurations> myList = new HashMap<>();
    repo.fileConverter(myList);
    assertThrows(JSONException.class, () -> JSONAssert
            .assertEquals("", repo.fileConverter(myList), true));
  }

}

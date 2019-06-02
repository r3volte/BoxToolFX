package BoxTool.Repository;

import BoxTool.Data.Box;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConfigurationsRepository {

  private Map<String, Object> components = new HashMap<>();


  public void add(String name, Integer number, Integer width, Integer height) {
    components.put(name, new Box(number, width, height));
  }

  public void delete(Object component) {
    components.remove(component);
  }

  public Map getComponent() {
    return components;
  }

  public String fileConverter(Map repo) {
    return new Gson().toJson(repo);
  }
}

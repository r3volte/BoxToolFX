package boxTool.repository;

import boxTool.data.Box;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ConfigurationsRepository {

    private Map<String, List<Box>> components = new HashMap<>();
    private List<Box> boxList = new ArrayList<>();


    public void add(String name, Integer number, Integer width, Integer height) {
        //boxList.add(new Box(number, width, height));
        components.put(name, boxList);
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

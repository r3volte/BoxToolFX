package boxTool.repository;

import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "dRepo")
public class DiscRepository implements DataRepository {

    private static List componentList = new ArrayList<>();


    @Override
    public void add(Object component) {
        componentList.add(component);
    }

    @Override
    public void delete(Object component) {
        componentList.remove(component);
    }

    @Override
    public List getComponent() {
        return componentList;
    }

    @Override
    public String fileConverter(List repo) {
        return new Gson().toJson(repo);
    }
}

package boxTool.repository;

import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "bRepo")
public class BoxRepository implements DataRepository {


    private static List componentList = new ArrayList<>();

    public void add(Object component) {
        componentList.add(component);
    }

    @Override
    public void delete(Object component) {
        componentList.remove(component);
    }

    public List getComponent() {
        return componentList;
    }

    public String fileConverter(List repo) {
        return new Gson().toJson(repo);
    }
}

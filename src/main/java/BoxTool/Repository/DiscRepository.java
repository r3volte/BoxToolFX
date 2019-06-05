package BoxTool.Repository;

import BoxTool.Data.Discs;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "dRepo")
public class DiscRepository implements DataRepository {

  private static List componentList = new ArrayList<>();

  public Discs createDisc(Integer number, Double diameter, Double height, Double height2, Double weigh) {
    return new Discs(number, diameter, height, height2, weigh);
  }

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

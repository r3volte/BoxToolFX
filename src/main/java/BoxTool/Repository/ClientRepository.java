package BoxTool.Repository;

import BoxTool.Data.Clients;
import BoxTool.Data.MountInstruction;
import BoxTool.Data.PcsPerBox;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "client")
public class ClientRepository implements DataRepository {

  private List componentList = new ArrayList<>();


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

  public Clients createBox(Integer id, String name, String discConf, PcsPerBox discPcsPerBox,
                           String coatedConf, PcsPerBox coatedPcsPerBox,
                           String drumConf, PcsPerBox drumPcsPerBox, MountInstruction montInst) {
    return new Clients(id, name, discConf, discPcsPerBox, coatedConf, coatedPcsPerBox, drumConf, drumPcsPerBox, montInst);
  }
}

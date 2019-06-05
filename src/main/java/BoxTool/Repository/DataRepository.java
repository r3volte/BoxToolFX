package BoxTool.Repository;


import java.util.List;

public interface DataRepository {

  void add(Object component);

  void delete(Object component);

  List getComponent();

  String fileConverter(List repo);
}

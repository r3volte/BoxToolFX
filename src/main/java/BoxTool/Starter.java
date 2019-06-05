package BoxTool;

import BoxTool.DatabaseOperations.ListType;
import BoxTool.DatabaseOperations.Read.DatabaseFileRead;
import BoxTool.DatabaseOperations.Write.DatabaseFileWrite;
import BoxTool.FileResources.Resources;
import BoxTool.Repository.ConfigurationsRepository;
import BoxTool.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

  @Autowired
  private DatabaseFileWrite databaseFileWrite;

  @Autowired
  private ConfigurationsRepository configurationsRepository;
  @Autowired
  @Qualifier("bRepo")
  private DataRepository dataRepository;
  @Autowired
  private DatabaseFileRead databaseFileRead;

  @Override
  public void run(String... args) throws Exception {

    databaseFileRead.databaseConfReader(Resources.ConfDBFile(), configurationsRepository.getComponent(), ListType.listTypeConf());
    System.out.println(configurationsRepository.getComponent().toString());
  }
}

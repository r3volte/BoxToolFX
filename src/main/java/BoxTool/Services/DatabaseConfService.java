package BoxTool.Services;

import BoxTool.FileResources.Resources;
import BoxTool.DatabaseOperations.ListType;
import BoxTool.DatabaseOperations.Read.DatabaseFileRead;
import BoxTool.Repository.ConfigurationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.FileNotFoundException;

public class DatabaseConfService {

  @Autowired
  private ConfigurationsRepository dataRepository;

  @Autowired
  @Qualifier("boxDB")
  private DatabaseFileRead databaseFileRead;


  public void databaseConfigReaderReader() throws FileNotFoundException {
    databaseFileRead.databaseConfReader(Resources.ConfDBFile(),
            dataRepository.getComponent(),
            ListType.listTypeConf());
  }

  public void addNewConf() {

  }
}

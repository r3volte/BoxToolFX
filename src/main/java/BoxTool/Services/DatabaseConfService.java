package BoxTool.Services;

import BoxTool.FileResources.Resources;
import BoxTool.DatabaseOperations.ListType;
import BoxTool.DatabaseOperations.Read.DatabaseFileRead;
import BoxTool.Repository.ConfigurationsRepository;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class DatabaseConfService {

  @Autowired
  private ConfigurationsRepository dataRepository;

  @Autowired
  private DatabaseFileRead databaseFileRead;


  public void databaseConfigReaderReader() throws FileNotFoundException {
    databaseFileRead.databaseConfReader(Resources.ConfDBFile(),
            dataRepository.getComponent(),
            ListType.listTypeConf());
  }

  public void configurationComboBox(ComboBox comboBox) {
    try {
      databaseConfigReaderReader();
      comboBox.getItems().setAll(dataRepository.getComponent().keySet());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public List initComboList(String box) {
   List temp = new ArrayList();
    dataRepository.getComponent().get(box);
    temp.addAll((Collection) dataRepository.getComponent().get(box));
    System.out.println(temp.size());
    return temp;
  }

}

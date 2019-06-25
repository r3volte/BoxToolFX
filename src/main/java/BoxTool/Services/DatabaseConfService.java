package boxTool.services;

import boxTool.fileResources.Resources;
import boxTool.databaseOperations.ListType;
import boxTool.databaseOperations.read.DatabaseFileRead;
import boxTool.repository.ConfigurationsRepository;

import javafx.scene.control.*;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class DatabaseConfService {

    private final ConfigurationsRepository dataRepository;
    private final DatabaseFileRead databaseFileRead;

    @Autowired
    public DatabaseConfService(ConfigurationsRepository dataRepository,
                               DatabaseFileRead databaseFileRead) {
        this.dataRepository = dataRepository;
        this.databaseFileRead = databaseFileRead;
    }


    public void databaseConfigReaderReader() throws FileNotFoundException {
        databaseFileRead.databaseConfReader(Resources.confDBFile(),
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

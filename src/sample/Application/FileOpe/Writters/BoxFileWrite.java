package sample.Application.FileOpe.Writters;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sample.Application.Data.Box;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryBoxDB;

public class BoxFileWrite implements FileWrite {

  private static final Logger logger = Logger.getLogger(BoxFileWrite.class.getName());
  private InMemoryBoxDB boxDB = new InMemoryBoxDB();

  @Override
  public void save(String fileOut) {
    FileWriter writer = null;
    try {
      writer = new
              FileWriter(fileOut);
    } catch (IOException e) {
      logger.log(Level.FINE, "File not found !");
    }
    ColumnPositionMappingStrategy mappingStrategy =
            new ColumnPositionMappingStrategy();
    mappingStrategy.setType(Box.class);

    String[] columns = new String[]
            {"number", "height", "width"};
    mappingStrategy.setColumnMapping(columns);

    StatefulBeanToCsvBuilder<Discs> builder =
            new StatefulBeanToCsvBuilder(writer);
    StatefulBeanToCsv beanWriter =
            builder.withMappingStrategy(mappingStrategy)
                    .withSeparator(',')
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
    try {
      beanWriter.write(boxDB.getBox());
    } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
      logger.log(Level.SEVERE, e.toString(), e);

      logger.log(Level.SEVERE, e.toString(), e);
    }
    try {
      writer.close();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
  }
}

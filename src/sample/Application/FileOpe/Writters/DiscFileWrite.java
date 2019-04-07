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

import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;


public class DiscFileWrite implements FileWrite {

  private static final Logger logger = Logger.getLogger(DiscFileWrite.class.getName());
  private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();

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
    mappingStrategy.setType(Discs.class);

    String[] columns = new String[]
            {"number", "diameter", "height", "height2", "weight"};
    mappingStrategy.setColumnMapping(columns);

    StatefulBeanToCsvBuilder<Discs> builder =
            new StatefulBeanToCsvBuilder(writer);
    StatefulBeanToCsv beanWriter =
            builder.withMappingStrategy(mappingStrategy)
                    .withSeparator(',')
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
    try {
      beanWriter.write(discsDB.getDiscs());
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

package sample.Application.FileOpe.Writters;


import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;

import java.io.FileWriter;
import java.io.IOException;


public class DiscWritter {

    private InMemoryDiscsDB discsDB = new InMemoryDiscsDB();



    public void saveFile() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        final String CSV_LOCATION = "discs.csv";
        FileWriter writer = new
                FileWriter(CSV_LOCATION);
        ColumnPositionMappingStrategy mappingStrategy=
                new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Discs.class);

        String[] columns = new String[]
                { "number", "diameter", "height", "height2", "weight" };
        mappingStrategy.setColumnMapping(columns);

        StatefulBeanToCsvBuilder<Discs> builder=
                new StatefulBeanToCsvBuilder(writer);
        StatefulBeanToCsv beanWriter =
                builder.withMappingStrategy(mappingStrategy).withSeparator(',').withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
        beanWriter.write(discsDB.getDiscs());
        writer.close();
    }

}

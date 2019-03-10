package sample.Application.FileReaders;

import sample.Application.Data.Discs;
import sample.Application.Databases.InMemoryDiscsDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DiscReader implements InMemoryDiscsDB {

   private String filein = "discs.txt";
   private String emptyLine = null;

   FileReader fileReader = new FileReader(filein);
   BufferedReader bufferedReader = new BufferedReader(fileReader);

    public DiscReader() throws FileNotFoundException {
    }

    public void readDFile() throws IOException {

        while ((emptyLine = bufferedReader.readLine()) !=null ){

            String[] temp = emptyLine.split(",");
            int number = Integer.parseInt(temp[0]);
            double diameter = Double.parseDouble(temp[1]);
            double height = Double.parseDouble(temp[2]);
            double heightX2 = Double.parseDouble(temp[3]);
            double weight = Double.parseDouble(temp[4]);
            discs.add(new Discs(number, diameter, height, heightX2, weight));
        }
        bufferedReader.close();
        discs.forEach(c -> System.out.println(c));
    }
}

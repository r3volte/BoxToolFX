package sample.Application.FileOpe.Readers;

import sample.Application.Data.Box;
import sample.Application.Databases.InMemoryBoxDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BoxReader implements InMemoryBoxDB {

    private String fileIn = "box.txt";
    private String emptyLine = null;

    private FileReader fileReader = new FileReader(fileIn);
    private BufferedReader bufferedReader = new BufferedReader(fileReader);

    public void readDFile() throws IOException {

        while ((emptyLine = bufferedReader.readLine()) !=null ){

            String[] temp = emptyLine.split(",");
            int number = Integer.parseInt(temp[0]);
            int width = Integer.parseInt(temp[1]);
            int height = Integer.parseInt(temp[2]);

            box.add(new Box(number, width, height));
        }
        bufferedReader.close();
        box.forEach(c -> System.out.println(c));
    }






    public BoxReader() throws FileNotFoundException {
    }
}

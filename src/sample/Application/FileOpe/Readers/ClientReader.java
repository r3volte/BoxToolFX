package sample.Application.FileOpe.Readers;


import sample.Application.Data.Clients;
import sample.Application.Databases.InMemoryClientsDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClientReader  {

    private String fileIn = "clients.csv";
    private String emptyLine = null;

    private FileReader fileReader = new FileReader(fileIn);
    private BufferedReader bufferedReader = new BufferedReader(fileReader);
    private InMemoryClientsDB clientsDB = new InMemoryClientsDB();

    public void readDFile() throws IOException {

        while ((emptyLine = bufferedReader.readLine()) !=null ){

            String[] temp = emptyLine.split(",");
            int id = Integer.parseInt(temp[0]);
            String name = temp[1];
            String discConf = temp[2];
            int discPcsPerBox = Integer.parseInt(temp[3]);
            String coatedConf = temp[4];
            int coatedPcsPerBox = Integer.parseInt(temp[5]);
            String drumConf = temp[6];
            int drumPcsPerBox = Integer.parseInt(temp[7]);
            String montInst = temp[8];

            clientsDB.getClients().add(new Clients(id,name,discConf,discPcsPerBox,
                    coatedConf,coatedPcsPerBox,drumConf,drumPcsPerBox,montInst));
        }
        bufferedReader.close();
        clientsDB.getClients().forEach(c -> System.out.println(c));
    }

    public ClientReader() throws FileNotFoundException {
    }
}

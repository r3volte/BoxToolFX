package sample.Application.FileOpe.Readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sample.Application.Data.Clients;
import sample.Application.Databases.InMemoryClientsDB;

public class ClientReader implements FileRead {

  private static final Logger logger = Logger.getLogger(ClientReader.class.getName());
  private String emptyLine = null;
  private InMemoryClientsDB clientsDB = new InMemoryClientsDB();

  @Override
  public void readFile(String fileIn) {
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(fileIn);
    } catch (FileNotFoundException e) {
      logger.log(Level.FINE, "File not found. Please restart program!");
    }
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    while (true) {
      try {
        if ((emptyLine = bufferedReader.readLine()) == null) {
          break;
        }
      } catch (IOException e) {
        logger.log(Level.SEVERE, e.toString(), e);
      }

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

      clientsDB.getClients().add(new Clients(id, name, discConf, discPcsPerBox,
              coatedConf, coatedPcsPerBox, drumConf, drumPcsPerBox, montInst));
    }
    try {
      bufferedReader.close();
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.toString(), e);
    }
    clientsDB.showDB();
  }
}

package sample.Application.Databases;

import java.util.ArrayList;
import java.util.List;

import sample.Application.Data.Clients;


public class InMemoryClientsDB implements InMemoryDB {

  private static List<Clients> clients = new ArrayList<>();

  public List<Clients> getClients() {
    return clients;
  }

  @Override
  public void showDB() {
    clients.stream().map(x -> x.toString())
            .forEach(x -> System.out.println(x));
  }
}

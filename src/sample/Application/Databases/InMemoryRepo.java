package sample.Application.Databases;

import com.google.gson.Gson;

import java.util.List;

public class InMemoryRepo {


  private InMemoryClientsDB clientsDB;
  private InMemoryDiscsDB discsDB;
  private InMemoryBoxDB boxDB;

  public InMemoryRepo(InMemoryClientsDB clientsDB, InMemoryDiscsDB discsDB, InMemoryBoxDB boxDB) {
    this.clientsDB = clientsDB;
    this.discsDB = discsDB;
    this.boxDB = boxDB;
  }

  public InMemoryClientsDB getClientsDB() {
    return clientsDB;
  }

  public InMemoryDiscsDB getDiscsDB() {
    return discsDB;
  }

  public InMemoryBoxDB getBoxDB() {
    return boxDB;
  }

  public String fileConverter(List repo) {
    return new Gson().toJson(repo);
  }

}

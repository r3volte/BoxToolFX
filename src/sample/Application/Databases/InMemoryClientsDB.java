package sample.Application.Databases;

import sample.Application.Data.Clients;
import java.util.ArrayList;

public interface InMemoryClientsDB {

    ArrayList<Clients> clients = new ArrayList<>();
}

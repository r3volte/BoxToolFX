package sample.Application.Databases;

import sample.Application.Data.Clients;
import java.util.ArrayList;

public class InMemoryClientsDB {

    private static ArrayList<Clients> clients = new ArrayList<>();

    public ArrayList<Clients> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Clients> clients) {
        InMemoryClientsDB.clients = clients;
    }
}

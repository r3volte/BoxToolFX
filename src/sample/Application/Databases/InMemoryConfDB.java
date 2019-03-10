package sample.Application.Databases;


import sample.Application.Data.Configurations;

import java.util.ArrayList;

public interface InMemoryConfDB {

    ArrayList<Configurations> conf = new ArrayList<>();
}

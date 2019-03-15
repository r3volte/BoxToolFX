package sample.Application.Databases;


import sample.Application.Data.Configurations;

import java.util.ArrayList;

public class InMemoryConfDB {

   private static ArrayList<Configurations> conf = new ArrayList<>();

    public static ArrayList<Configurations> getConf() {
        return conf;
    }

    public static void setConf(ArrayList<Configurations> conf) {
        InMemoryConfDB.conf = conf;
    }
}

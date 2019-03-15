package sample.Application.Databases;

import sample.Application.Data.Discs;
import java.util.ArrayList;

public class InMemoryDiscsDB {

    private static ArrayList<Discs> discs = new ArrayList<Discs>();

    public ArrayList<Discs> getDiscs() {
        return discs;
    }

    public void setDiscs(ArrayList<Discs> discs) {
        InMemoryDiscsDB.discs = discs;
    }
}

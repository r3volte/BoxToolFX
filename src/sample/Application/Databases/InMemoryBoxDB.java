package sample.Application.Databases;


import sample.Application.Data.Box;

import java.util.ArrayList;

public class InMemoryBoxDB {

    private static ArrayList<Box> box = new ArrayList<>();

    public ArrayList<Box> getBox() {
        return box;
    }

    public void setBox(ArrayList<Box> box) {
        InMemoryBoxDB.box = box;
    }
}

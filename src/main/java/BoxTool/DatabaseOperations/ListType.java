package boxTool.databaseOperations;

import boxTool.data.Box;
import boxTool.data.Clients;
import boxTool.data.Discs;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListType {

    public static Type listDisk() {
        return new TypeToken<ArrayList<Discs>>() {
        }.getType();
    }

    public static Type listBox() {
        return new TypeToken<ArrayList<Box>>() {
        }.getType();
    }

    public static Type listClient() {
        return new TypeToken<ArrayList<Clients>>() {
        }.getType();
    }

    public static Type listTypeConf() {
        return new TypeToken<HashMap<String, List<Box>>>() {
        }.getType();
    }
}

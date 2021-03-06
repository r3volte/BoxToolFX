package boxTool.fileResources;

import javafx.scene.image.Image;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Resources {


    public static String mainFrame() {
        return "/xml/NewWindows.fxml";
    }

    public static String boxFramePath() {
        return "/xml/addBox.fxml";
    }

    public static String errorPath() {
        return "/xml/errorBoxPanel.fxml";
    }

    public static String clientFramePath() {
        return "/xml/addClient.fxml";
    }

    public static String clientFrameErrorPath() {
        return "/xml/errorClientPanel.fxml";
    }

    public static String confFramePath() {
        return "/xml/addConf.fxml";
    }

    public static String discFramePath() {
        return "/xml/adddisc.fxml";
    }

    public static String discFrameErrorPath() {
        return "/xml/errorPanel.fxml";
    }

    public static String discSearchFramePath() {
        return "/xml/searchDisc.fxml";
    }

    public static String discDBFile() {
        return "discs.json";
    }

    public static String boxDBFile() {
        return "box.json";
    }

    public static String neuDB() {
        return "boxTest.json";
    }

    public static String clientDBFile() {
        return "clients.json";
    }

    public static String confDBFile() {
        return "config.json";
    }

    public static void setLocale() {
        Locale.setDefault(new Locale("en"));
    }

    public static Image appIcon() {
        return new Image("icon/icon.png");
    }
}

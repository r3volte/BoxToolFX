package BoxTool.FileResources;

import org.springframework.stereotype.Component;

@Component
public class Resources {


  public static String mainFrame() {
    return "/xml/NewWindows.fxml";
  }

  public static String boxFramePath() {
    return "/xml/addBox.fxml";
  }

  public static String boxFrameErrorPath() {
    return "/xml/errorBoxPanel.fxml";
  }

  public static String confFramePath() {
    return "/xml/addConf.fxml";
  }

  public static String DiscDBFile() {
    return "/json/discs.json";
  }

  public static String BoxDBFile() {
    return "box.json";
  }

  public static String ClientDBFile() {
    return "/json/clients.json";
  }

  public static String ConfDBFile() {
    return "/json/config.json";
  }
}

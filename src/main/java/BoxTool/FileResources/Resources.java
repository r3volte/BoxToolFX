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

  public static String DiscDBFile() {
    return "discs.json";
  }

  public static String BoxDBFile() {
    return "box.json";
  }

  public static String ClientDBFile() {
    return "clients.json";
  }

  public static String ConfDBFile() {
    return "config.json";
  }
}

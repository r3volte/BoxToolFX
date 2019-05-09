package sample.Application.Selecting;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.Application.Data.Configurations;
import sample.Application.Databases.InMemoryConfDB;

import java.util.ArrayList;
import java.util.List;

public class CheckConfSelector {


  public void adder(TextField field, CheckBox cb1, CheckBox cb3, CheckBox cb4, CheckBox cb5,
             CheckBox cb2, CheckBox cb6, CheckBox cb7, CheckBox cb8, CheckBox cb9, CheckBox cb10, CheckBox cb11
          , CheckBox cb12, CheckBox cb13, CheckBox cb14, CheckBox cb15, CheckBox cb16, CheckBox cb17, CheckBox cb18, CheckBox cb19
          , CheckBox cb20, CheckBox cb21, CheckBox cb22, CheckBox cb23, CheckBox cb24, CheckBox cb25, CheckBox cb26, CheckBox cb27
          , CheckBox cb28, CheckBox cb29, CheckBox cb30, CheckBox cb31, CheckBox cb32, CheckBox c33, CheckBox cb34, CheckBox cb35){

    String num = String.valueOf(field.getText());
    List<Configurations> temp = new ArrayList<>();
    if (cb1.isSelected()){
      temp.add(new Configurations(num,230,73,240));
    }
    if (cb2.isSelected()){
      temp.add(new Configurations(num,272,51,255));
    }
    if (cb3.isSelected()){
      temp.add(new Configurations(num,280,73,255));
    }
    if (cb4.isSelected()){
      temp.add(new Configurations(num,285,73,255));
    }
    if (cb5.isSelected()){
      temp.add(new Configurations(num,288,73,255));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,325,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,330,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,340,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,350,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,352,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,355,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,360,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,361,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,362,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,365,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,370,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,375,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,377,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,379,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,380,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,381,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,382,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,383,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,384,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,385,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,388,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,389,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,390,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,400,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,402,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,408,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,410,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,420,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,430,73,240));
    }
    if (cb1.isSelected()){
      temp.add(new Configurations(num,440,73,240));
    }

    InMemoryConfDB confDB = new InMemoryConfDB();
    confDB.addOtherLists(temp);
    System.out.println(confDB.getConf());
  }
}

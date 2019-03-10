package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class ErrorMessage extends AddDiscController{


    public void errorDialog(){
        JFXDialogLayout layout;layout = new JFXDialogLayout();
        JFXButton ok = new JFXButton("Okey");
        JFXDialog error = new JFXDialog(rootPane,layout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent c )->{
            error.close();
        });
        layout.setBody(new Text("Please fill all fields with data, can't add new disc !!!"));
        layout.setActions(ok);
        error.show();
    }
}

package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class ErrorMessage extends AddDiscController{

    private AddDiscController erc = new AddDiscController();


    public void errorDialog(){
        JFXDialogLayout layout;layout = new JFXDialogLayout();
        layout.setStyle("-fx-background-color: #2A2E37;");
        JFXButton ok = new JFXButton("Okey");
        JFXDialog error = new JFXDialog(erc.rootPane,layout,JFXDialog.DialogTransition.TOP);
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent c )->{
            error.close();
        });
        layout.setBody(new Text("Please fill all fields with data, can't add new disc !!!"));
        layout.setActions(ok);
        error.show();
    }
}

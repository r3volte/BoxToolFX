package boxTool.ui;

import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class SceneChanges {


    public void initDiscPanel(AnchorPane pnl_discs, AnchorPane pnl_clients, AnchorPane pnl_boxes, AnchorPane pnl_conf) {
        pnl_discs.toFront();
        pnl_discs.setVisible(true);
        pnl_clients.setVisible(false);
        pnl_boxes.setVisible(false);
        pnl_conf.setVisible(false);
    }

    public void initClientPanel(AnchorPane pnl_discs, AnchorPane pnl_clients, AnchorPane pnl_boxes, AnchorPane pnl_conf) {
        pnl_clients.toFront();
        pnl_clients.setVisible(true);
        pnl_discs.setVisible(false);
        pnl_boxes.setVisible(false);
        pnl_conf.setVisible(false);
    }

    public void initBoxPanel(AnchorPane pnl_discs, AnchorPane pnl_clients, AnchorPane pnl_boxes, AnchorPane pnl_conf) {
        pnl_boxes.toFront();
        pnl_boxes.setVisible(true);
        pnl_discs.setVisible(false);
        pnl_clients.setVisible(false);
        pnl_conf.setVisible(false);
    }

    public void initConfPanel(AnchorPane pnl_discs, AnchorPane pnl_clients, AnchorPane pnl_boxes, AnchorPane pnl_conf) {
        pnl_conf.toFront();
        pnl_conf.setVisible(true);
        pnl_discs.setVisible(false);
        pnl_clients.setVisible(false);
        pnl_boxes.setVisible(false);
    }

}

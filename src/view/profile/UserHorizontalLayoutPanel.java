package view.profile;

import javax.swing.*;
import java.util.List;

public class UserHorizontalLayoutPanel extends JPanel{
    UserHorizontalLayoutPanel(List<JPanel> listProductPanels){
        for (JPanel panel : listProductPanels){
            this.add(panel);
        }
    }
}

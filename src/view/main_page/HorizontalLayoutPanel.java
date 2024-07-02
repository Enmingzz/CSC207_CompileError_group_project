package view.main_page;

import javax.swing.*;
import java.util.List;

public class HorizontalLayoutPanel extends JPanel{
    HorizontalLayoutPanel(List<JPanel> listProductPanels){
        for (JPanel panel : listProductPanels){
            this.add(panel);
        }
    }
}

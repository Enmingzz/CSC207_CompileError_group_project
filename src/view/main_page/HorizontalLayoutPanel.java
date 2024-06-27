package view.main_page;

import javax.swing.*;
import java.util.ArrayList;

public class HorizontalLayoutPanel extends JPanel{
    HorizontalLayoutPanel(ArrayList<JPanel> listProductPanels){
        for (JPanel panel : listProductPanels){
            this.add(panel);
        }
    }
}

package view.search_product;

import javax.swing.*;
import java.util.List;

/**
 * The HorizontalLayoutPanel class represents a panel that arranges child panels in a horizontal layout.
 */
public class HorizontalLayoutPanel extends JPanel {
    /**
     * Constructs a HorizontalLayoutPanel with the specified list of panels.
     *
     * @param listProductPanels the list of panels to be arranged horizontally
     */
    HorizontalLayoutPanel(List<JPanel> listProductPanels){
        for (JPanel panel : listProductPanels){
            this.add(panel);
        }
    }
}

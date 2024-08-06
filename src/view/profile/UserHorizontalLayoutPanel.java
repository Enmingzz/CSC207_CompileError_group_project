package view.profile;

import javax.swing.*;
import java.util.List;

/**
 * UserHorizontalLayoutPanel is a custom JPanel that arranges a list of JPanel components in a horizontal layout.
 */
public class UserHorizontalLayoutPanel extends JPanel{

    /**
     * Constructs a UserHorizontalLayoutPanel with the specified list of JPanel components.
     *
     * @param listProductPanels the list of JPanel components to be added to the horizontal layout
     */
    UserHorizontalLayoutPanel(List<JPanel> listProductPanels){
        for (JPanel panel : listProductPanels){
            this.add(panel);
        }
    }
}

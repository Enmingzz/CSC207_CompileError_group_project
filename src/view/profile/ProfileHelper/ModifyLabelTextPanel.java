package view.profile.ProfileHelper;
import javax.swing.*;

/**
 * ModifyLabelTextPanel is a custom JPanel that contains a label and a text field.
 * It provides a method to set and add these components to the panel.
 */
public class ModifyLabelTextPanel extends JPanel {

    /**
     * Constructs a ModifyLabelTextPanel with no components.
     */
    public ModifyLabelTextPanel() {}

    /**
     * Sets the label and text field components for this panel.
     *
     * @param label     the JLabel to be added to the panel
     * @param textField the JTextField to be added to the panel
     */
    public void setText(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}

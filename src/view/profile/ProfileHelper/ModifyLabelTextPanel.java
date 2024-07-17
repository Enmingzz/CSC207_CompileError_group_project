package view.profile.ProfileHelper;
import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
public class ModifyLabelTextPanel extends JPanel {
    public ModifyLabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}

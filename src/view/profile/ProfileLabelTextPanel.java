package view.profile;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class ProfileLabelTextPanel extends JPanel {
    ProfileLabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}

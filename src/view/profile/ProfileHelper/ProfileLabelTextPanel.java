package view.profile.ProfileHelper;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
public class ProfileLabelTextPanel extends JPanel {

    public ProfileLabelTextPanel(JLabel label, JLabel textField) {
        this.add(label);
        this.add(textField);
    }
}

package view.profile;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class ProfileLabelTextPanel extends JPanel {
    ProfileLabelTextPanel(JLabel label, JLabel textlable) {
        this.add(label);
        this.add(textlable);
    }
    ProfileLabelTextPanel(JLabel label, JList textlable) {
        this.add(label);
        this.add(new JScrollPane(textlable));
    }
}

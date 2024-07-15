package view.profile.ProfileListener;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
public class ProfileLabelTextPanel extends JPanel {
    public ProfileLabelTextPanel(JLabel label, JLabel textlable) {
        this.add(label);
        this.add(textlable);
    }
    ProfileLabelTextPanel(JLabel label, JList textlable) {
        this.add(label);
        this.add(new JScrollPane(textlable));
    }
}

package view.profile.ProfileHelper;

import javax.swing.*;
import java.awt.*;

/**
 * A panel containing a label and a text field.
 */
public class ProfileLabelTextPanel extends JPanel {

    public ProfileLabelTextPanel(JLabel label, JLabel textField) {
        textField.setFont( new Font("Arial", Font.PLAIN, 30));
        label.setFont( new Font("Times New Roman", Font.BOLD, 30));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);

        labelPanel.add(label);
        labelPanel.add(Box.createHorizontalGlue());

        labelPanel.add(textField);
        labelPanel.add(Box.createHorizontalGlue());

        this.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.lightGray));
        this.setLayout(new BorderLayout());
        this.add(labelPanel, BorderLayout.CENTER);
    }
}

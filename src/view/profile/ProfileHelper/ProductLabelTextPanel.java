package view.profile.ProfileHelper;

import javax.swing.*;
import java.awt.*;

/**
 * A panel containing a label and a text field.
 */
public class ProductLabelTextPanel extends JPanel {

    public ProductLabelTextPanel(JLabel label, JLabel textField) {
        textField.setFont( new Font("Arial", Font.PLAIN, 20));
        label.setFont( new Font("Times New Roman", Font.BOLD, 20));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);

        labelPanel.add(Box.createRigidArea(new Dimension(350, 0)));
        labelPanel.add(label);
        labelPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        labelPanel.add(textField);

        this.setLayout(new BorderLayout());
        this.add(labelPanel, BorderLayout.CENTER);
    }
}

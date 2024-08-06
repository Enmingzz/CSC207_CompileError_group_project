package view.profile.ProfileHelper;

import javax.swing.*;
import java.awt.*;

/**
 * ProductLabelTextPanel is a custom JPanel that contains a label and a text field (another label) arranged horizontally.
 * It sets custom fonts for both the label and the text field and ensures a consistent layout.
 */
public class ProductLabelTextPanel extends JPanel {

    /**
     * Constructs a ProductLabelTextPanel with the specified label and text field.
     * Both the label and text field are styled and arranged in a horizontal layout.
     *
     * @param label     the JLabel representing the label of the panel
     * @param textField the JLabel representing the text field of the panel
     */
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

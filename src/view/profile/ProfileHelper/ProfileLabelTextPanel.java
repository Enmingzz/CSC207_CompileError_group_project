package view.profile.ProfileHelper;

import javax.swing.*;
import java.awt.*;

/**
 * ProfileLabelTextPanel is a custom JPanel that contains a label and a text field (another label) arranged horizontally.
 * It sets custom fonts for both the label and the text field and ensures a consistent layout with a border.
 */
public class ProfileLabelTextPanel extends JPanel {

    /**
     * Constructs a ProfileLabelTextPanel with the specified label and text field.
     * Both the label and text field are styled and arranged in a horizontal layout with a border.
     *
     * @param label     the JLabel representing the label of the panel
     * @param textField the JLabel representing the text field of the panel
     */
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

package view.profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile view";

    private JTextField studentNumberViewField = new JTextField(20);
    private JTextField studentNameViewField = new JTextField(20);
    private JTextField studentEmailViewField = new JTextField(20);
    private JTextField studentRatingViewField = new JTextField(20);
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

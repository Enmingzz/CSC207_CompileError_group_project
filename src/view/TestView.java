package view;

import interface_adapter.EmailVerificationController;
import interface_adapter.SignupController;
import interface_adapter.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class TestView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "test view";

    public TestView() {
        this.add(new JTextField(15));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

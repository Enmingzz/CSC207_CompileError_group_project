package view;

import entity.CommonProduct;
import interface_adapter.LoginState;
import interface_adapter.LoginViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "login in";
    private final LoginViewModel loginViewModel;

    final JTextField studentNumberField = new JTextField(15);
    private final JLabel studentNumberErrorField = new JLabel();

    final JTextField passwordField = new JTextField(15);
    private final JLabel passwordErrorField = new JLabel();

    final JButton logInButton;

    public LoginView(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);
        this.logInButton = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        LabelTextPanel studentNumberInfo = new LabelTextPanel(new JLabel(loginViewModel.NUMBER_LABEL), studentNumberField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(loginViewModel.PASSWORD_LABEL), passwordField);

        JLabel title = new JLabel(loginViewModel.TITLE_LABEL);
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

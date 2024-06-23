package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "login in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;

    private final JTextField studentNumberField = new JTextField(15);
    private final JLabel studentNumberErrorField = new JLabel();

    private final JPasswordField passwordField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    private final JButton logInButton;

    public LoginView(LoginViewModel loginViewModel, LoginController loginController) {
        this.loginViewModel = loginViewModel;
        this.loginController = loginController;
        this.loginViewModel.addPropertyChangeListener(this);
        this.logInButton = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        LabelTextPanel studentNumberInfo = new LabelTextPanel(new JLabel(loginViewModel.NUMBER_LABEL), studentNumberField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(loginViewModel.PASSWORD_LABEL), passwordField);

        JLabel title = new JLabel(loginViewModel.TITLE_LABEL);
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        buttons.add(logInButton);

        class LoginButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(logInButton)) {
                    try {
                        loginController.execute(studentNumberField.getText(),
                                String.valueOf(passwordField.getPassword()));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        logInButton.addActionListener(new LoginButtonListener());

        this.add(title);
        this.add(studentNumberInfo);
        this.add(passwordInfo);
        this.add(logInButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        if (state.getStudentNumberError() != null) {
            JOptionPane.showMessageDialog(this, state.getStudentNumberError());
        }
    }
}

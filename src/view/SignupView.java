package view;

import interface_adapter.SignupController;
import interface_adapter.SignupState;
import interface_adapter.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.EventListener;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final JTextField emailInputField = new JTextField(15);
    private final JTextField UtoridInputField = new JTextField(15);
    private final JTextField verificationCodeInputField = new JTextField(15);
    private final SignupController signupController;

    private final JButton signUp;
    private final JButton emailVerification;

    public SignupView(SignupController controller, SignupViewModel signupViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(signupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(signupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(signupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(signupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);
        LabelTextPanel emailInfo = new LabelTextPanel(new JLabel(signupViewModel.EMAIL_LABEL), emailInputField);
        LabelTextPanel verificationCodeInfo = new LabelTextPanel(new JLabel(signupViewModel.VERIFICATION_LABEL), verificationCodeInputField);



        JPanel buttons = new JPanel();
        signUp = new JButton(signupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);

        JPanel button2 = new JPanel();
        emailVerification = new JButton(signupViewModel.SEND_EMAIL_VERIFICATION_LABEL);
        button2.add(emailVerification);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(1,2));
        container.add(verificationCodeInfo);
        container.add(button2);

        class SignUpButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(signUp)) {
                    try {
                        signupController.execute(usernameInputField.getText(),
                                String.valueOf(passwordInputField.getPassword()),
                                String.valueOf(repeatPasswordInputField.getPassword()), String.valueOf(emailInputField.getText()), String.valueOf(verificationCodeInputField.getText()), String.valueOf(UtoridInputField.getText()));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        class UsernameKeyListener implements KeyListener{
            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        }

        signUp.addActionListener(new SignUpButtonListener());
        usernameInputField.addKeyListener(new UsernameKeyListener());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(emailInfo);
        this.add(container);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }

}

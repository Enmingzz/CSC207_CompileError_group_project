package view.signup;

import interface_adapter.signup.EmailVerificationController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

/**
 * The SignupView class for the signup pages.
 * Two controller:
 *      SignupController which is used to check if student number does exist, password is same as the repeat password and email verification code is correct.
 *      EmailVerificationController, which is responsible for sending email verification code and return generated email verification code.
 * Use the Java email API in this view page model, which is exactly in EmailVerification controller.
 */

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;

    private final JTextField usernameInputField = new JTextField(15);
    private final JTextField studentNameInputField = new JTextField(15);
    private final JTextField emailInputField = new JTextField(15);
    private final JTextField verificationCodeInputField = new JTextField(15);

    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);

    private final SignupController signupController;
    private final EmailVerificationController emailVerificationController;

    private final JButton signUp;
    private final JButton emailVerification;

    /**
     * Initialized this in SignupUsecaseFactory
     * @param controller SignUpController
     * @param signupViewModel SignupViewModel
     * @param emailVerificationController EmailVerificationController
     */

    public SignupView(SignupController controller, SignupViewModel signupViewModel, EmailVerificationController emailVerificationController) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.emailVerificationController = emailVerificationController;
        this.signupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(signupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        SignupLabelTextPanel usernameInfo = new SignupLabelTextPanel(
                new JLabel(signupViewModel.USERNAME_LABEL), usernameInputField);
        SignupLabelTextPanel passwordInfo = new SignupLabelTextPanel(
                new JLabel(signupViewModel.PASSWORD_LABEL), passwordInputField);
        SignupLabelTextPanel repeatPasswordInfo = new SignupLabelTextPanel(
                new JLabel(signupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);
        SignupLabelTextPanel emailInfo = new SignupLabelTextPanel(new JLabel(signupViewModel.EMAIL_LABEL), emailInputField);
        SignupLabelTextPanel verificationCodeInfo = new SignupLabelTextPanel(new JLabel(signupViewModel.VERIFICATION_LABEL), verificationCodeInputField);
        SignupLabelTextPanel studentNumberInfo = new SignupLabelTextPanel(new JLabel(signupViewModel.STUDENT_NUMBER_LABEL), studentNameInputField);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JPanel buttons = new JPanel();
        signUp = new JButton(signupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);

        JPanel button2 = new JPanel();
        this.emailVerification = new JButton(signupViewModel.SEND_EMAIL_VERIFICATION_LABEL);
        button2.add(emailVerification);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(1,2));
        container.add(verificationCodeInfo);
        container.add(button2);

        class SignUpButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(signUp)) {
                    try {
                        //System.out.println(signupViewModel.getState().hashCode());
                        //System.out.println(signupViewModel.getState().getGeneratedVerificationCode());
                        signupController.execute(usernameInputField.getText(),
                                String.valueOf(passwordInputField.getPassword()),
                                String.valueOf(repeatPasswordInputField.getPassword()), String.valueOf(emailInputField.getText()), signupViewModel.getState().getGeneratedVerificationCode(), String.valueOf(verificationCodeInputField.getText()), String.valueOf(studentNameInputField.getText()));
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

        class VerificationCodeButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(emailVerification)) {
                    try {
                        emailVerificationController.execute(emailInputField.getText());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        signUp.addActionListener(new SignUpButtonListener());
        emailVerification.addActionListener(new VerificationCodeButtonListener());
        usernameInputField.addKeyListener(new UsernameKeyListener());

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(studentNumberInfo);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(emailInfo);
        this.add(container);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {

    }

    /**
     * Alert error when detect state changes in SignupViewPresenter, especially in FailedPresenter.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }

}

package view.signup;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.LoginController;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.search_product.SearchProductByTagController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.EmailVerificationController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import view.shopping_cart.ShoppingCartView;

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
    private final JTextField productSearchByNameInputField = new JTextField(15);

    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);

    private final SignupController signupController;
    private final EmailVerificationController emailVerificationController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;
    private final SearchProductByNameController searchProductByNameController;
    private final SearchProductByTagController searchProductByTagController;
    private final ViewLoginPageController viewLoginPageController;

    private final JButton signUp;
    private final JButton emailVerification;
    private final JButton viewLoginButton;
    private final JButton mainPageButton;
    private final JButton shoppingCartButton;
    private final JButton searchProductByNameButton;
    private final JButton searchProductByTagButton;

    /**
     * Initialized this in SignupUsecaseFactory
     * @param controller SignUpController
     * @param signupViewModel SignupViewModel
     * @param emailVerificationController EmailVerificationController
     */

    public SignupView(SignupController controller, SignupViewModel signupViewModel,
                      EmailVerificationController emailVerificationController, MainPageController
                              mainPageController, ShoppingCartController shoppingCartController,
                      SearchProductByNameController searchProductByNameController,
                      SearchProductByTagController searchProductByTagController,
                      ViewLoginPageController viewLoginPageController) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.emailVerificationController = emailVerificationController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.searchProductByNameController = searchProductByNameController;
        this.searchProductByTagController = searchProductByTagController;
        this.viewLoginPageController = viewLoginPageController;
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

        signUp.addActionListener(new SignUpButtonListener());

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

        usernameInputField.addKeyListener(new UsernameKeyListener());

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
        emailVerification.addActionListener(new VerificationCodeButtonListener());

        JPanel viewLoginButtonPanel = new JPanel();
        this.viewLoginButton = new JButton("log in");
        viewLoginButtonPanel.add(viewLoginButton);

        class LoginButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(viewLoginButton)) {
                    try {
                        viewLoginPageController.execute();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        viewLoginButton.addActionListener(new LoginButtonListener());

        JPanel mainPageButtonPanel = new JPanel();
        this.mainPageButton = new JButton("main page");
        mainPageButtonPanel.add(mainPageButton);

        class MainPageButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(mainPageButton)) {
                    try {
                        UserFactory commonUserFactory = new CommonUserFactory();
                        User user = commonUserFactory.createUser("", "", "", 0, "");
                        mainPageController.execute(user);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        mainPageButton.addActionListener(new MainPageButtonListener());

        JPanel shoppingCartButtonPanel = new JPanel();
        this.shoppingCartButton = new JButton("shopping cart");
        shoppingCartButtonPanel.add(shoppingCartButton);

        class ShoppingCartButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(shoppingCartButton)) {
                    try {
                        UserFactory commonUserFactory = new CommonUserFactory();
                        User user = commonUserFactory.createUser("", "", "", 0, "");
                        shoppingCartController.execute(user);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        shoppingCartButton.addActionListener(new ShoppingCartButtonListener());

        JPanel searchProductByNameButtonPanel = new JPanel();
        this.searchProductByNameButton = new JButton("search product");
        searchProductByNameButtonPanel.add(searchProductByNameButton);

        class SearchProductByNameButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(searchProductByNameButtonPanel)) {
                    try {
                        UserFactory commonUserFactory = new CommonUserFactory();
                        User user = commonUserFactory.createUser("", "", "", 0, "");
                        searchProductByNameController.execute(user,
                                String.valueOf(productSearchByNameInputField.getText()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        searchProductByNameButton.addActionListener(new SearchProductByNameButtonListener());

        JPanel searchProductByTagButtonPanel = new JPanel();
        this.searchProductByTagButton = new JButton("search product");
        searchProductByTagButtonPanel.add(searchProductByTagButton);

        class SearchProductByTagButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(searchProductByTagButtonPanel)) {
                    try {
                        UserFactory commonUserFactory = new CommonUserFactory();
                        User user = commonUserFactory.createUser("", "", "", 0, "");
                        //TODO need to implement this method
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        searchProductByTagButton.addActionListener(new SearchProductByTagButtonListener());

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

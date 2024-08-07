package view.signup;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.search_product.search.SearchProductByNameController;
import interface_adapter.search_product.search.SearchProductByTagController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.signup.email_verification.EmailVerificationController;
import interface_adapter.signup.signup.SignupController;
import interface_adapter.signup.signup.SignupState;
import interface_adapter.signup.signup.SignupViewModel;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import view.TopBarSampleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;

    private final JButton signUp;
    private final JButton emailVerification;
    private final JButton viewLoginButton;

    private final JPanel signUpPanel = new JPanel();
    private TopBarSampleView topBar;

    /**
     * Constructor for the SignupView class.
     *
     * @param controller the controller for handling signup operations
     * @param signupViewModel the view model for the signup view
     * @param emailVerificationController the controller for handling email verification
     * @param mainPageController the controller for navigating to the main page
     * @param shoppingCartController the controller for managing the shopping cart
     * @param searchProductByNameController the controller for searching products by name
     * @param searchProductByTagController the controller for searching products by tag
     * @param viewLoginPageController the controller for navigating to the login page
     * @param getSearchPageController the controller for navigating to the search page
     * @param viewSignupPageController the controller for navigating to the signup page
     * @param logOutController the controller for logging out
     * @param viewProfileController the controller for viewing the profile page
     */

    public SignupView(SignupController controller, SignupViewModel signupViewModel,
                      EmailVerificationController emailVerificationController, MainPageController
                              mainPageController, ShoppingCartController shoppingCartController,
                      SearchProductByNameController searchProductByNameController,
                      SearchProductByTagController searchProductByTagController,
                      ViewLoginPageController viewLoginPageController,
                      GetSearchPageController getSearchPageController,
                      ViewSignupPageController viewSignupPageController,
                      LogOutController logOutController,
                      ViewProfileController viewProfileController) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.emailVerificationController = emailVerificationController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.searchProductByNameController = searchProductByNameController;
        this.searchProductByTagController = searchProductByTagController;
        this.viewLoginPageController = viewLoginPageController;
        this.signupViewModel.addPropertyChangeListener(this);

        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;

        JLabel title = new JLabel(signupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        SignupLabelTextPanel usernameInfo = new SignupLabelTextPanel(
                new JLabel(signupViewModel.USERNAME_LABEL), usernameInputField);
        SignupLabelTextPanel passwordInfo = new SignupLabelTextPanel(
                new JLabel(signupViewModel.PASSWORD_LABEL), passwordInputField);
        SignupLabelTextPanel repeatPasswordInfo = new SignupLabelTextPanel(
                new JLabel(signupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);
        JPanel emailInfo = new JPanel();
        emailInfo.add(new JLabel(signupViewModel.EMAIL_LABEL));
        emailInfo.add(emailInputField);
        emailInfo.add(new JLabel(signupViewModel.EMAIL_AT));
        SignupLabelTextPanel verificationCodeInfo = new SignupLabelTextPanel(new JLabel(signupViewModel.VERIFICATION_LABEL), verificationCodeInputField);
        SignupLabelTextPanel studentNumberInfo = new SignupLabelTextPanel(new JLabel(signupViewModel.STUDENT_NUMBER_LABEL), studentNameInputField);


        signUpPanel.setLayout(new BoxLayout(signUpPanel, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();

        signUp = new JButton(signupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);

//        JPanel button2 = new JPanel();
//        button2.add(emailVerification);
        this.emailVerification = new JButton(signupViewModel.SEND_EMAIL_VERIFICATION_LABEL);
        JPanel container = new JPanel();
        container.add(verificationCodeInfo);
        container.add(emailVerification);

        class SignUpButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(signUp)) {
                    try {
                        //System.out.println(signupViewModel.getState().hashCode());
                        //System.out.println(signupViewModel.getState().getGeneratedVerificationCode());
                        signupController.execute(usernameInputField.getText(),
                                String.valueOf(passwordInputField.getPassword()),
                                String.valueOf(repeatPasswordInputField.getPassword()),
                                String.valueOf(emailInputField.getText()),
                                signupViewModel.getState().getGeneratedVerificationCode(),
                                String.valueOf(verificationCodeInputField.getText()),
                                String.valueOf(studentNameInputField.getText()));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        signUp.addActionListener(new SignUpButtonListener());

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

        signUpPanel.add(title);
        signUpPanel.add(studentNumberInfo);
        signUpPanel.add(usernameInfo);
        signUpPanel.add(passwordInfo);
        signUpPanel.add(repeatPasswordInfo);
        signUpPanel.add(emailInfo);
        signUpPanel.add(container);
        signUpPanel.add(buttons);

       // UserFactory userFactory = new CommonUserFactory();
       // User user = userFactory.createUser("", "", "", 0, "");
//        JPanel topBar = new TopBarSampleView(user,
//                getSearchPageController, viewSignupPageController, viewLoginPageController,
//                shoppingCartController, logOutController, viewProfileController, mainPageController);
        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);
        this.add(signUpPanel, BorderLayout.CENTER);
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

        topBar = new TopBarSampleView(this.signupViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);

        //this.add(topBar, BorderLayout.NORTH);
        topBar.removeAll();
        topBar.add(new JLabel(signupViewModel.TITLE_LABEL));
        topBar.repaint();
        topBar.revalidate();
    }

}

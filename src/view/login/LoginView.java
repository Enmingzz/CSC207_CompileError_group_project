package view.login;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
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
 * The {@link LoginView} class represents the login view in the application.
 * It handles user interactions for logging in and displays the login interface.
 */
public class LoginView extends JPanel implements PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;

    private final JTextField studentNumberField = new JTextField(15);
    private final JLabel studentNumberErrorField = new JLabel();

    private final JPasswordField passwordField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();
    private JPanel topBar;

    private final JButton logInButton;
    private final JPanel logInPanel = new JPanel();

    /**
     * Constructs a new {@link LoginView}.
     *
     * @param loginViewModel        the login view model
     * @param loginController       the login controller
     * @param mainPageController    the main page controller
     * @param getSearchPageController the search page controller
     * @param viewSignupPageController the signup page controller
     * @param viewLoginPageController the login page controller
     * @param shoppingCartController the shopping cart controller
     * @param logOutController      the logout controller
     * @param viewProfileController the profile view controller
     */
    public LoginView(LoginViewModel loginViewModel,
                     LoginController loginController,
                     MainPageController mainPageController,
                     GetSearchPageController getSearchPageController,
                     ViewSignupPageController viewSignupPageController,
                     ViewLoginPageController viewLoginPageController,
                     ShoppingCartController shoppingCartController,
                     LogOutController logOutController,
                     ViewProfileController viewProfileController) {
        this.loginViewModel = loginViewModel;
        this.loginController = loginController;
        System.out.println("loginView intitalized");

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;

        this.setLayout(new BorderLayout());
        logInPanel.setLayout(new BoxLayout(logInPanel, BoxLayout.Y_AXIS));
        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

        this.loginViewModel.addPropertyChangeListener(this);
        this.logInButton = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        LoginLabelTextPanel studentNumberInfo =
                new LoginLabelTextPanel(new JLabel(loginViewModel.NUMBER_LABEL), studentNumberField);
        LoginLabelTextPanel passwordInfo =
                new LoginLabelTextPanel(new JLabel(loginViewModel.PASSWORD_LABEL), passwordField);

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
                        System.out.println(String.valueOf(passwordField.getPassword()));
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
        logInPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        logInPanel.add(title);
        logInPanel.add(studentNumberInfo);
        logInPanel.add(passwordInfo);
        logInPanel.add(logInButton);
        this.add(logInPanel, BorderLayout.CENTER);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("propertyChange login received");
        topBar.removeAll();
        topBar.add(new TopBarSampleView(loginViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();
        studentNumberField.setText("");
        passwordField.setText("");
        LoginState state = (LoginState) evt.getNewValue();
        if (state.getIsChanged()) {
            JOptionPane.showMessageDialog(this, state.getStudentNumberError());
        }
    }
}

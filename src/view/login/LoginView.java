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
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import view.TopBarSampleView;
import view.signup.SignupLabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

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

    private final JButton logInButton;

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

        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("", "", "", 0, "");
        JPanel topBar = new TopBarSampleView(user,
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
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
                        viewLoginPageController.execute();
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
        System.out.println("propertyChange login received");
        LoginState state = (LoginState) evt.getNewValue();
        if (state.getStudentNumberError() != null) {
            JOptionPane.showMessageDialog(this, state.getStudentNumberError());
        }
//
//        UserFactory userFactory = new CommonUserFactory();
//        User user = userFactory.createUser("", "", "", 0, "");
//        JPanel topBar = new TopBarSampleView(user,
//                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
//        this.add(topBar);

    }
}

package view.profile;

import interface_adapter.login.LoginController;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.ViewSignupPageController;
import view.TopBarSampleView;
import view.profile.ProfileHelper.ProfileLabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;

public class UserProfileView extends JFrame implements PropertyChangeListener, ActionListener {
    public final String viewName = "UserProfile View";
    private final ViewProfileViewModel viewModel;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;
    private final LoginController loginController;
    private final SignupController signupController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final LogOutController logOutController;


    private final JButton goMain;
    private final JButton goShoppingCart;
    private final JButton goLogin;
    private final JButton goSignup;
    private final JButton goProfile;

    private JLabel studentNumberViewField = new JLabel();
    private JLabel studentNameViewField = new JLabel();
    private JLabel studentEmailViewField = new JLabel();
    private JLabel studentRatingViewField = new JLabel();

    public UserProfileView(MainPageController mainPageController,
                           ShoppingCartController shoppingCartController,
                           ViewProfileViewModel profileViewModel,
                           ViewProfileController viewProfileController,
                           LoginController loginController,
                           SignupController signupController,
                           GetSearchPageController getSearchPageController,
                           ViewSignupPageController viewSignupPageController,
                           ViewLoginPageController viewLoginPageController,
                           LogOutController logOutController){
        this.viewModel = profileViewModel;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.loginController = loginController;
        this.signupController = signupController;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.logOutController = logOutController;

        JPanel topBar = new TopBarSampleView(this.viewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);

        viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(viewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        studentNumberViewField.setText(viewModel.getState().getUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getUser().getName());
        studentEmailViewField.setText(viewModel.getState().getUser().getEmail());
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getUser().getUserRating()));

        ProfileLabelTextPanel userNameInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERNAME_LABEL), studentNameViewField);
        ProfileLabelTextPanel userIDInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERID_LABEL), studentNumberViewField);
        ProfileLabelTextPanel userEmail = new ProfileLabelTextPanel(new JLabel(profileViewModel.USEREMAIL_LABEL), studentEmailViewField);
        ProfileLabelTextPanel userRating = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERRATING_LABLE), studentRatingViewField);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 5));

        goMain = new JButton(profileViewModel.MAIN_BUTTON_LABEL);
        bottomPanel.add(goMain);
        goLogin = new JButton(profileViewModel.LOGIN_BUTTON_LABEL);
        bottomPanel.add(goLogin);
        goSignup = new JButton(profileViewModel.SIGNUP_BUTTON_LABEL);
        bottomPanel.add(goSignup);
        goShoppingCart = new JButton(profileViewModel.SHOPPING_BUTTON_LABEL);
        bottomPanel.add(goShoppingCart);
        goProfile = new JButton(profileViewModel.PROFILE_BUTTON_LABEL);
        bottomPanel.add(goProfile);

        goMain.addActionListener(this);
        goLogin.addActionListener(this);
        goSignup.addActionListener(this);
        goShoppingCart.addActionListener(this);
        goProfile.addActionListener(this);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(userNameInfo);
        this.add(userIDInfo);
        this.add(userEmail);
        this.add(userRating);
        this.add(mainPanel);

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewProfileState state = (ViewProfileState) evt.getNewValue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(goMain)) {
            try {
                mainPageController.execute(viewModel.getState().getUser());
            } catch (SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource().equals(goShoppingCart)){
            try {
                shoppingCartController.execute(viewModel.getState().getUser());
            } catch (SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource().equals(goProfile)){
            viewProfileController.execute(viewModel.getState().getUser());
        } else {
            System.out.println("Other Method has not implemented yet!");
        }

        ViewProfileState newState = (ViewProfileState) e.getSource();

        JPanel topBar = new TopBarSampleView(newState.getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);

    }
}


package view.profile;

import interface_adapter.login.LoginController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.modify_profile.ViewModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.SignupController;
import view.profile.ProfileListener.ManageProductListener;
import view.profile.ProfileListener.ModifyProfileListener;
import view.profile.ProfileListener.ProfileLabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;

public class ProfileView extends JFrame implements PropertyChangeListener, ActionListener {
    public final String viewName = "Profile View";

    private final ManageProductController manageProductController;
    private final ViewModifyProfileController viewModifyProfileController;

    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;
    private final LoginController loginController;
    private final SignupController signupController;

    private final ViewProfileViewModel viewModel;
    private final JButton manageProduct;
    private final JButton modifyName;
    private final JButton modifyPassword;

    private final JButton goMain;
    private final JButton goShoppingCart;
    private final JButton goLogin;
    private final JButton goSignup;
    private final JButton goProfile;

    private JLabel studentNumberViewField = new JLabel();
    private JLabel studentNameViewField = new JLabel();
    private JLabel studentEmailViewField = new JLabel();
    private JLabel studentRatingViewField = new JLabel();

    public ProfileView (MainPageController mainPageController,
                        ShoppingCartController shoppingCartController,
                        ManageProductController manageProductController,
                        ViewModifyProfileController viewModifyProfileController,
                        ViewProfileController viewProfileController,
                        LoginController loginController,
                        SignupController signupController,
                        ViewProfileViewModel profileViewModel){

        this.manageProductController = manageProductController;
        this.viewModifyProfileController = viewModifyProfileController;
        this.viewProfileController = viewProfileController;
        this.loginController = loginController;
        this.signupController = signupController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;

        this.viewModel = profileViewModel;
        viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(profileViewModel.TITLE_LABEL);
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
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 1));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 5));

        manageProduct = new JButton(profileViewModel.MANAGEPRODUCT_BUTTONLABEL);
        leftPanel.add(manageProduct);
        modifyName = new JButton(profileViewModel.MODIFYNAME_BUTTON_LABEL);
        leftPanel.add(modifyName);
        modifyPassword = new JButton(profileViewModel.MODIFYPASSWORD_BUTTON_LABEL);
        leftPanel.add(modifyPassword);

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

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        manageProduct.addActionListener(new ManageProductListener(manageProductController, viewModel));
        modifyName.addActionListener(new ModifyProfileListener(viewModifyProfileController, viewModel));
        modifyPassword.addActionListener(new ModifyProfileListener(viewModifyProfileController, viewModel));

        goMain.addActionListener(this);
        goLogin.addActionListener(this);
        goSignup.addActionListener(this);
        goShoppingCart.addActionListener(this);
        goProfile.addActionListener(this);

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
        viewModel.setState(state);
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
        } else{
            System.out.println("Other Method has not implemented yet!");
        }

    }
}

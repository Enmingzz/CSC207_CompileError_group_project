package view.profile;

import interface_adapter.login.LoginController;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.modify_profile.ViewModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.ViewSignupPageController;
import view.TopBarSampleView;
import view.profile.ProfileHelper.ManageProductListener;
import view.profile.ProfileHelper.ModifyProfileListener;
import view.profile.ProfileHelper.ProfileLabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;

public class ProfileView extends JPanel implements PropertyChangeListener {
    public final String viewName = "Profile View";

    private final ManageProductController manageProductController;
    private final ViewModifyProfileController viewModifyProfileController;

    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final LogOutController logOutController;


    private final ViewProfileViewModel viewModel;
    private final JButton manageProduct;
    private final JButton modifyName;
    private final JButton modifyPassword;

    private JLabel studentNumberViewField = new JLabel();
    private JLabel studentNameViewField = new JLabel();
    private JLabel studentEmailViewField = new JLabel();
    private JLabel studentRatingViewField = new JLabel();

    public ProfileView (MainPageController mainPageController,
                        ManageProductController manageProductController,
                        ViewModifyProfileController viewModifyProfileController,
                        ViewProfileViewModel profileViewModel,
                        GetSearchPageController getSearchPageController,
                        ViewSignupPageController viewSignupPageController,
                        ViewLoginPageController viewLoginPageController,
                        ShoppingCartController shoppingCartController,
                        LogOutController logOutController,
                        ViewProfileController viewProfileController){

        this.manageProductController = manageProductController;
        this.viewModifyProfileController = viewModifyProfileController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.logOutController = logOutController;


        this.viewModel = profileViewModel;
        viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(profileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel topBar = new TopBarSampleView(this.viewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.SOUTH);

        studentNumberViewField.setText(viewModel.getState().getUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getUser().getName());
        studentEmailViewField.setText(viewModel.getState().getUser().getEmail());
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getUser().getUserRating()));

        ProfileLabelTextPanel userNameInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERNAME_LABEL), studentNameViewField);
        ProfileLabelTextPanel userIDInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERID_LABEL), studentNumberViewField);
        ProfileLabelTextPanel userEmail = new ProfileLabelTextPanel(new JLabel(profileViewModel.USEREMAIL_LABEL), studentEmailViewField);
        ProfileLabelTextPanel userRating = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERRATING_LABLE), studentRatingViewField);

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

        this.add(leftPanel, BorderLayout.WEST);
        this.add(bottomPanel, BorderLayout.SOUTH);

        manageProduct.addActionListener(new ManageProductListener(manageProductController, viewModel));
        modifyName.addActionListener(new ModifyProfileListener(viewModifyProfileController, viewModel));
        modifyPassword.addActionListener(new ModifyProfileListener(viewModifyProfileController, viewModel));

        this.add(title);
        this.add(userNameInfo);
        this.add(userIDInfo);
        this.add(userEmail);
        this.add(userRating);

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewProfileState state = (ViewProfileState) evt.getNewValue();
        viewModel.setState(state);
    }
}

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
import java.util.Objects;

public class ProfileView extends JPanel implements PropertyChangeListener {
    public final String viewName = "profile view";

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
    private JLabel studentPasswordViewField = new JLabel();
    private JLabel messageField = new JLabel("");
    private JPanel infoPanel = new JPanel();

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
        this.setLayout(new BorderLayout());
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JPanel topBar = new TopBarSampleView(this.viewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

        studentNumberViewField.setText(viewModel.getState().getUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getUser().getName());
        studentPasswordViewField.setText(viewModel.getState().getUser().getPassword());
        studentEmailViewField.setText(viewModel.getState().getUser().getEmail());
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getUser().getUserRating()));

        ProfileLabelTextPanel userNameInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERNAME_LABEL), studentNameViewField);
        ProfileLabelTextPanel passwordInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.PASSWORD_LABEL), studentPasswordViewField);
        ProfileLabelTextPanel userIDInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERID_LABEL), studentNumberViewField);
        ProfileLabelTextPanel userEmail = new ProfileLabelTextPanel(new JLabel(profileViewModel.USEREMAIL_LABEL), studentEmailViewField);
        ProfileLabelTextPanel userRating = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERRATING_LABLE), studentRatingViewField);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 1));

        manageProduct = new JButton(profileViewModel.MANAGEPRODUCT_BUTTONLABEL);
        leftPanel.add(manageProduct);
        modifyName = new JButton(profileViewModel.MODIFYNAME_BUTTON_LABEL);
        leftPanel.add(modifyName);
        modifyPassword = new JButton(profileViewModel.MODIFYPASSWORD_BUTTON_LABEL);
        leftPanel.add(modifyPassword);

        this.add(leftPanel, BorderLayout.WEST);

        manageProduct.addActionListener(new ManageProductListener(manageProductController, viewModel));
        modifyName.addActionListener(new ModifyProfileListener(viewModifyProfileController, viewModel));
        modifyPassword.addActionListener(new ModifyProfileListener(viewModifyProfileController, viewModel));

        infoPanel.add(title);
        infoPanel.add(userNameInfo);
        infoPanel.add(passwordInfo);
        infoPanel.add(userIDInfo);
        infoPanel.add(userEmail);
        infoPanel.add(userRating);
        infoPanel.add(messageField);

        this.add(infoPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewProfileState state = (ViewProfileState) evt.getNewValue();
        viewModel.setState(state);

        studentNameViewField.setText(viewModel.getState().getUser().getName());
        studentPasswordViewField.setText(viewModel.getState().getUser().getPassword());
        messageField.setText(viewModel.getState().getMessage());


    }
}

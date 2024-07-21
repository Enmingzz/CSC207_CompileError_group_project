package view.profile;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.LoginController;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewUserProfileState;
import interface_adapter.profile.view_profile.ViewUserProfileViewModel;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.ViewProductController;
import view.TopBarSampleView;
import view.main_page.AllProductsPanel;
import view.profile.ProfileHelper.ProfileLabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserProfileView extends JPanel implements PropertyChangeListener {
    public final String viewName = "user profile View";
    private final ViewUserProfileViewModel viewModel;
    private final ViewProductController viewProductController;
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

    private JLabel studentNumberViewField = new JLabel();
    private JLabel studentNameViewField = new JLabel();
    private JLabel studentEmailViewField = new JLabel();
    private JLabel studentRatingViewField = new JLabel();
    private JPanel topBar;
    private JPanel allProductsPanel;
    public UserProfileView(MainPageController mainPageController,
                           ShoppingCartController shoppingCartController,
                           ViewUserProfileViewModel profileViewModel,
                           ViewProfileController viewProfileController,
                           LoginController loginController,
                           SignupController signupController,
                           GetSearchPageController getSearchPageController,
                           ViewSignupPageController viewSignupPageController,
                           ViewLoginPageController viewLoginPageController,
                           LogOutController logOutController,
                           ViewProductController viewProductController) {
        this.viewModel = profileViewModel;
        this.viewProductController = viewProductController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.loginController = loginController;
        this.signupController = signupController;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.logOutController = logOutController;

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

        viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(viewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        studentNumberViewField.setText(viewModel.getState().getSellerUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getSellerUser().getName());
        studentEmailViewField.setText(viewModel.getState().getSellerUser().getEmail());
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getSellerUser().getUserRating()));

        ProfileLabelTextPanel userNameInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERNAME_LABEL), studentNameViewField);
        ProfileLabelTextPanel userIDInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERID_LABEL), studentNumberViewField);
        ProfileLabelTextPanel userEmail = new ProfileLabelTextPanel(new JLabel(profileViewModel.USEREMAIL_LABEL), studentEmailViewField);
        ProfileLabelTextPanel userRating = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERRATING_LABLE), studentRatingViewField);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(userNameInfo);
        this.add(userIDInfo);
        this.add(userEmail);
        this.add(userRating);

        ArrayList<Product> allProducts = viewModel.getState().getListProduct();

        allProductsPanel = new ViewUserProductPanel(allProducts, viewModel, viewProductController);
        this.add(new JScrollPane(allProductsPanel));

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        topBar.removeAll();
        topBar.add(new TopBarSampleView(viewModel.getState().getBuyerUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();

        ViewUserProfileState state = (ViewUserProfileState) evt.getNewValue();

        ArrayList<Product> allProducts = state.getListProduct();

        allProductsPanel.removeAll();
        allProductsPanel.add(new ViewUserProductPanel(allProducts, viewModel, viewProductController));
        allProductsPanel.repaint();
        allProductsPanel.revalidate();

    }
}


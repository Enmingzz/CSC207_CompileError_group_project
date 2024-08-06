package view.profile;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewUserProfileState;
import interface_adapter.profile.view_profile.ViewUserProfileViewModel;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import interface_adapter.view_product.non_logged_in_view.ViewProductController;
import view.TopBarSampleView;
import view.profile.ProfileHelper.ProfileLabelTextPanel;
import view.profile.ProfileHelper.ProfileTitleLabel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * UserProfileView is a custom JPanel that displays the profile information of a user along with their products.
 * This class implements PropertyChangeListener to respond to changes in the user profile state.
 */
public class UserProfileView extends JPanel implements PropertyChangeListener {
    public final String viewName = "user profile view";
    private final ViewUserProfileViewModel viewModel;
    private final ViewProductController viewProductController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final LogOutController logOutController;

    private JLabel studentNumberViewField = new JLabel();
    private JLabel studentNameViewField = new JLabel();
    private JLabel studentEmailViewField = new JLabel();
    private JLabel studentRatingViewField = new JLabel();
    private JPanel infoPanel = new JPanel();
    private JPanel topBar;
    private JPanel allProductsPanel;

    /**
     * Constructs a UserProfileView with the specified controllers and view model.
     *
     * @param mainPageController        the controller for the main page
     * @param shoppingCartController    the controller for the shopping cart
     * @param profileViewModel          the view model for the user profile view
     * @param viewProfileController     the controller for viewing the profile
     * @param getSearchPageController   the controller for getting the search page
     * @param viewSignupPageController  the controller for viewing the signup page
     * @param viewLoginPageController   the controller for viewing the login page
     * @param logOutController          the controller for logging out
     * @param viewProductController     the controller for viewing a product
     */
    public UserProfileView(MainPageController mainPageController,
                           ShoppingCartController shoppingCartController,
                           ViewUserProfileViewModel profileViewModel,
                           ViewProfileController viewProfileController,
                           GetSearchPageController getSearchPageController,
                           ViewSignupPageController viewSignupPageController,
                           ViewLoginPageController viewLoginPageController,
                           LogOutController logOutController,
                           ViewProductController viewProductController) throws IOException {
        this.viewModel = profileViewModel;
        this.viewProductController = viewProductController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;


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
        ProfileTitleLabel title = new ProfileTitleLabel(viewModel.TITLE_LABEL);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        studentNumberViewField.setText(viewModel.getState().getSellerUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getSellerUser().getName());
        studentEmailViewField.setText(viewModel.getState().getSellerUser().getEmail());
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getSellerUser().getUserRating()));

        ProfileLabelTextPanel userNameInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERNAME_LABEL), studentNameViewField);
        ProfileLabelTextPanel userIDInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERID_LABEL), studentNumberViewField);
        ProfileLabelTextPanel userEmail = new ProfileLabelTextPanel(new JLabel(profileViewModel.USEREMAIL_LABEL), studentEmailViewField);
        ProfileLabelTextPanel userRating = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERRATING_LABLE), studentRatingViewField);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        infoPanel.add(title);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        infoPanel.add(userNameInfo);
        infoPanel.add(userIDInfo);
        infoPanel.add(userEmail);
        infoPanel.add(userRating);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 20, 80));

        this.add(infoPanel, BorderLayout.CENTER);

        ArrayList<Product> allProducts = viewModel.getState().getListProduct();

        allProductsPanel = new ViewUserProductPanel(allProducts, viewModel, viewProductController);
        this.add(new JScrollPane(allProductsPanel), BorderLayout.SOUTH);

    }

    /**
     * Responds to property changes in the view model.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        topBar.removeAll();
        topBar.add(new TopBarSampleView(viewModel.getState().getBuyerUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();

        studentNumberViewField.setText(viewModel.getState().getSellerUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getSellerUser().getName());
        studentEmailViewField.setText(viewModel.getState().getSellerUser().getEmail());
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getSellerUser().getUserRating()));

        infoPanel.repaint();
        infoPanel.revalidate();

//        this.add(infoPanel, BorderLayout.CENTER);

        ViewUserProfileState state = (ViewUserProfileState) evt.getNewValue();

        ArrayList<Product> allProducts = state.getListProduct();

        allProductsPanel.removeAll();
        allProductsPanel.add(new ViewUserProductPanel(allProducts, viewModel, viewProductController));
        allProductsPanel.repaint();
        allProductsPanel.revalidate();

        this.repaint();
        this.revalidate();

    }
}


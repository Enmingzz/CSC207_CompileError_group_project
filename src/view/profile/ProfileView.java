package view.profile;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.modify_profile.ViewModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.view_search_page.GetSearchPageController;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartController;
import interface_adapter.signup.view_signup_page.ViewSignupPageController;
import view.TopBarSampleView;
import view.profile.ProfileHelper.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

/**
 * A view for displaying and managing user profiles.
 * This class extends JPanel and implements PropertyChangeListener to respond to property changes in the view model.
 */
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
    private final JButton modifyProfile;
    private final JButton showProfile;

    private JLabel studentNumberViewField = new JLabel();
    private JLabel studentNameViewField = new JLabel();
    private JLabel studentEmailViewField = new JLabel();
    private JLabel studentRatingViewField = new JLabel();
    private JLabel studentPasswordViewField = new JLabel();
    private JLabel messageField = new JLabel("");
    private JPanel infoPanel = new JPanel();
    private SetButtonHelper setButtonHelper;

    private JPanel topBar;

    /**
     * Constructs a ProfileView with the specified controllers and view model.
     *
     * @param mainPageController              the main page controller
     * @param manageProductController         the controller for managing products
     * @param viewModifyProfileController     the controller for modifying the profile
     * @param profileViewModel                the view model for the profile view
     * @param getSearchPageController         the controller for getting the search page
     * @param viewSignupPageController        the controller for viewing the signup page
     * @param viewLoginPageController         the controller for viewing the login page
     * @param shoppingCartController          the controller for managing the shopping cart
     * @param logOutController                the controller for logging out
     * @param viewProfileController           the controller for viewing the profile
     * @throws IOException if an error occurs during image loading
     */
    public ProfileView (MainPageController mainPageController,
                        ManageProductController manageProductController,
                        ViewModifyProfileController viewModifyProfileController,
                        ViewProfileViewModel profileViewModel,
                        GetSearchPageController getSearchPageController,
                        ViewSignupPageController viewSignupPageController,
                        ViewLoginPageController viewLoginPageController,
                        ShoppingCartController shoppingCartController,
                        LogOutController logOutController,
                        ViewProfileController viewProfileController) throws IOException {

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
        ProfileTitleLabel title = new ProfileTitleLabel(profileViewModel.TITLE_LABEL);

        this.setLayout(new BorderLayout());
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

        studentNumberViewField.setText(viewModel.getState().getUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getUser().getName());
        studentPasswordViewField.setText(viewModel.getState().getUser().getPassword());
        studentEmailViewField.setText(viewModel.getState().getUser().getEmail());
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getUser().getUserRating()));

        ProfileLabelTextPanel userNameInfo = new ProfileLabelTextPanel(new JLabel(viewModel.USERNAME_LABEL), studentNameViewField);
        ProfileLabelTextPanel passwordInfo = new ProfileLabelTextPanel(new JLabel(viewModel.PASSWORD_LABEL), studentPasswordViewField);
        ProfileLabelTextPanel userIDInfo = new ProfileLabelTextPanel(new JLabel(viewModel.USERID_LABEL), studentNumberViewField);
        ProfileLabelTextPanel userEmail = new ProfileLabelTextPanel(new JLabel(viewModel.USEREMAIL_LABEL), studentEmailViewField);
        ProfileLabelTextPanel userRating = new ProfileLabelTextPanel(new JLabel(viewModel.USERRATING_LABLE), studentRatingViewField);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 1));

        showProfile = new JButton(profileViewModel.VIEW_PROFILE_BOTTON_LABEL);
        setButtonHelper = new SetButtonHelper("/pic/user.jpg", showProfile);
        setButtonHelper.setButton();
        leftPanel.add(showProfile);

        manageProduct = new JButton(profileViewModel.MANAGEPRODUCT_BUTTONLABEL);
        setButtonHelper = new SetButtonHelper("/pic/manage.jpg", manageProduct);
        setButtonHelper.setButton();
        leftPanel.add(manageProduct);

        modifyProfile = new JButton(profileViewModel.MODIFYPROFILE_BUTTON_LABEL);
        setButtonHelper = new SetButtonHelper("/pic/modify.jpg", modifyProfile);
        setButtonHelper.setButton();
        leftPanel.add(modifyProfile);

        manageProduct.addActionListener(new ManageProductListener(manageProductController, viewModel));
        modifyProfile.addActionListener(new ModifyProfileListener(viewModifyProfileController, viewModel));
        class ViewProfileListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt){
                if(evt.getSource().equals(showProfile)){
                    try{
                        viewProfileController.execute(profileViewModel.getState().getUser());
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        showProfile.addActionListener(new ViewProfileListener());
        this.add(leftPanel, BorderLayout.WEST);
        infoPanel.add(title);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        infoPanel.add(userNameInfo);
        infoPanel.add(passwordInfo);
        infoPanel.add(userIDInfo);
        infoPanel.add(userEmail);
        infoPanel.add(userRating);
        infoPanel.add(messageField);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 20, 20));

        this.add(infoPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    /**
     * Responds to property changes in the view model.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewProfileState state = (ViewProfileState) evt.getNewValue();
        String message = state.getMessage();
        state.setMessage("");
        viewModel.setState(state);

        studentNumberViewField.setText(viewModel.getState().getUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getUser().getName());
        studentPasswordViewField.setText(viewModel.getState().getUser().getPassword());
        studentEmailViewField.setText(viewModel.getState().getUser().getEmail()+"@mail.utoronto.ca");
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getUser().getUserRating()));
        messageField.setText(message);

        infoPanel.repaint();
        infoPanel.revalidate();
        this.repaint();
        this.revalidate();

        topBar.removeAll();
        topBar.add(new TopBarSampleView(viewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();
    }
}

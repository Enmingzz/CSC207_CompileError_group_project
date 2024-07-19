package view.profile;

import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.modify_profile.ModifyProfileState;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import view.TopBarSampleView;
import view.profile.ProfileHelper.ModifyLabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class ModifyProfileView extends JPanel implements ActionListener, PropertyChangeListener {

    private final ModifyProfileViewModel modifyProfileViewModel = new ModifyProfileViewModel();
    private final ModifyProfileController modifyProfileController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;
    private final SearchProductByNameController searchProductByNameController;
    private final  ViewProfileController viewProfileController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
        private final LogOutController logOutController;

    private final UserFactory userFactory;

    public final String viewName = "modify profile";

    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    final JButton confirmButton;
    final JButton backButton;
    private JPanel topBar = new JPanel();

    public ModifyProfileView(UserFactory userFactory, ModifyProfileController modifyProfileController,
                             MainPageController mainPageController,
                             ShoppingCartController shoppingCartController,
                             SearchProductByNameController searchProductByNameController,
                             ViewProfileController viewProfileController,
                             GetSearchPageController getSearchPageController,
                             ViewSignupPageController viewSignupPageController,
                             ViewLoginPageController viewLoginPageController,
                             LogOutController logOutController) {
        this.modifyProfileController = modifyProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.searchProductByNameController = searchProductByNameController;
        this.viewProfileController = viewProfileController;
        this.userFactory = userFactory;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.logOutController = logOutController;

        this.setLayout(new BorderLayout());

        topBar = new TopBarSampleView(this.modifyProfileViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

        modifyProfileViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(modifyProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        ModifyLabelTextPanel usernameInfo = new ModifyLabelTextPanel(
                new JLabel(modifyProfileViewModel.USERNAME_LABEL), usernameInputField);
        ModifyLabelTextPanel passwordInfo = new ModifyLabelTextPanel(
                new JLabel(modifyProfileViewModel.PASSWORD_LABEL), passwordInputField);

        JPanel buttons = new JPanel();
        confirmButton = new JButton(modifyProfileViewModel.CONFIRM_BUTTON_LABEL);
        buttons.add(confirmButton);
        backButton = new JButton(modifyProfileViewModel.BACK_BUTTON_LABEL);
        buttons.add(backButton);
        confirmButton.addActionListener(this);
        backButton.addActionListener(this);

        mainPanel.add(buttons);
        mainPanel.add(usernameInfo);
        mainPanel.add(passwordInfo);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(confirmButton)){
            try {
                ModifyProfileState currentState = modifyProfileViewModel.getState();
                User currentUser = currentState.getUser();
                User newUser = userFactory.createUser(usernameInputField.getText(), Arrays.toString(passwordInputField.getPassword()),
                        currentUser.getEmail(), currentUser.getUserRating(), currentUser.getStudentNumber());

                currentState.setUser(newUser);
                modifyProfileViewModel.setState(currentState);

                modifyProfileController.execute(modifyProfileViewModel.getState().getUser());

            } catch (SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            viewProfileController.execute(modifyProfileViewModel.getState().getUser());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ModifyProfileState state = (ModifyProfileState) evt.getNewValue();
        modifyProfileViewModel.setState(state);

        this.remove(topBar);
        topBar = new TopBarSampleView(this.modifyProfileViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

    }
}

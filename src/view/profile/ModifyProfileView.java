package view.profile;

import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.modify_profile.ModifyProfileState;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.shopping_cart.ShoppingCartController;
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

    private final UserFactory userFactory;

    public final String viewName = "modify profile";

    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    final JButton confirmButton;
    final JButton backButton;

    public ModifyProfileView(UserFactory userFactory, ModifyProfileController modifyProfileController,
                             MainPageController mainPageController, ShoppingCartController shoppingCartController,
                             SearchProductByNameController searchProductByNameController, ViewProfileController viewProfileController) {
        this.modifyProfileController = modifyProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.searchProductByNameController = searchProductByNameController;
        this.viewProfileController = viewProfileController;
        this.userFactory = userFactory;

        modifyProfileViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(modifyProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

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
    }
}

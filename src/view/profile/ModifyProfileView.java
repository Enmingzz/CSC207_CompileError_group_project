package view.profile;

import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.modify_profile.ModifyProfileState;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.shopping_cart.ShoppingCartController;
import view.profile.ProfileListener.ModifyLabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ModifyProfileView extends JPanel implements ActionListener, PropertyChangeListener {

    private final ModifyProfileViewModel modifyProfileViewModel = new ModifyProfileViewModel();
    private final ModifyProfileController modifyProfileController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;
    private final SearchProductByNameController searchProductByNameController;

    public final String viewName = "Modify Profile View";

    final JTextField usernameInputField = new JTextField(15);
    final JPasswordField passwordInputField = new JPasswordField(15);
    final JButton confirmButton;

    public ModifyProfileView(ModifyProfileController modifyProfileController, MainPageController mainPageController, ShoppingCartController shoppingCartController, SearchProductByNameController searchProductByNameController) {
        this.modifyProfileController = modifyProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.searchProductByNameController = searchProductByNameController;

        modifyProfileViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(modifyProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        ModifyLabelTextPanel usernameInfo = new ModifyLabelTextPanel(
                new JLabel(modifyProfileViewModel.USERNAME_LABEL), usernameInputField);
        ModifyLabelTextPanel passwordInfo = new ModifyLabelTextPanel(
                new JLabel(modifyProfileViewModel.PASSWORD_LABEL), passwordInputField);

        JPanel buttons = new JPanel();
        confirmButton = new JButton(modifyProfileViewModel.BUTTON_LABEL);
        buttons.add(confirmButton);
        confirmButton.addActionListener(this);

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                ModifyProfileState currentState = modifyProfileViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                modifyProfileViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modifyProfileController.execute(modifyProfileViewModel.getState());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ModifyProfileState state = (ModifyProfileState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(ModifyProfileState state) {
        usernameInputField.setText(state.getname());
        passwordInputField.setText(state.getPassword());
    }
}

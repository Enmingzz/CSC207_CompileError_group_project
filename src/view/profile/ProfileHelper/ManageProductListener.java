package view.profile.ProfileHelper;

import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.view_profile.ViewProfileViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ManageProductListener is an ActionListener that handles the action of managing products.
 */
public class ManageProductListener implements ActionListener {
    private final ManageProductController manageProductController;
    private final ViewProfileViewModel profileViewModel;

    /**
     * Constructs a ManageProductListener with the specified manage product controller and profile view model.
     *
     * @param manageProductController the controller responsible for managing products
     * @param profileViewModel        the view model for the profile view
     */
    public ManageProductListener(ManageProductController manageProductController, ViewProfileViewModel profileViewModel){
        this.manageProductController = manageProductController;
        this.profileViewModel = profileViewModel;
    }

    /**
     * Invoked when an action occurs. Executes the manage product action.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            manageProductController.execute(profileViewModel.getState().getUser());
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

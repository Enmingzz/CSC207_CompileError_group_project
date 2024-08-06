package view.profile.ProfileHelper;

import interface_adapter.profile.modify_profile.ViewModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ModifyProfileListener is an ActionListener that handles the action of modifying a user profile.
 * This listener interacts with the ViewModifyProfileController to execute the modification.
 */
public class ModifyProfileListener implements ActionListener {
    private final ViewModifyProfileController viewModifyProfileController;
    private final ViewProfileViewModel profileViewModel;

    /**
     * Constructs a ModifyProfileListener with the specified controller and view model.
     *
     * @param viewModifyProfileController the controller responsible for modifying the profile
     * @param profileViewModel            the view model for the profile view
     */
    public ModifyProfileListener(ViewModifyProfileController viewModifyProfileController, ViewProfileViewModel profileViewModel){
        this.viewModifyProfileController = viewModifyProfileController;
        this.profileViewModel = profileViewModel;
    }

    /**
     * Invoked when an action occurs. Executes the modify profile action by calling the appropriate method in the controller.
     * It also handles potential SQL and IO exceptions by throwing a RuntimeException.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            System.out.println("profile view click modify profile" + profileViewModel.getState().getUser().getName());
            viewModifyProfileController.execute(profileViewModel.getState().getUser());
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

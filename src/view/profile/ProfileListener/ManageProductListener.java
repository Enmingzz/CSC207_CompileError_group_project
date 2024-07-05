package view.profile.ProfileListener;

import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.view_profile.ViewProfileViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ManageProductListener implements ActionListener {
    private final ManageProductController manageProductController;
    private final ViewProfileViewModel profileViewModel;

    public ManageProductListener(ManageProductController manageProductController, ViewProfileViewModel profileViewModel){
        this.manageProductController = manageProductController;
        this.profileViewModel = profileViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            manageProductController.execute(profileViewModel.getState().getUser());
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

package view.profile.ProfileListener;

import interface_adapter.profile.ManageProduct.ManageProductController;
import interface_adapter.profile.ProfileViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ManageProductListener implements ActionListener {
    private final ManageProductController manageProductController;
    private final ProfileViewModel profileViewModel;

    public ManageProductListener(ManageProductController manageProductController, ProfileViewModel profileViewModel){
        this.manageProductController = manageProductController;
        this.profileViewModel = profileViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            manageProductController.execute(profileViewModel.getState().getUser());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

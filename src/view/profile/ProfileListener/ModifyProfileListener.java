package view.profile.ProfileListener;

import interface_adapter.profile.ModifyProfile.ModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ModifyProfileListener implements ActionListener {
    private final ModifyProfileController modifyProfileController;
    private final ViewProfileViewModel profileViewModel;

    public ModifyProfileListener(ModifyProfileController modifyProfileController, ViewProfileViewModel profileViewModel){
        this.modifyProfileController = modifyProfileController;
        this.profileViewModel = profileViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            modifyProfileController.execute(profileViewModel.getState().getUser());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

package view.profile.ProfileHelper;

import interface_adapter.profile.modify_profile.ViewModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ModifyProfileListener implements ActionListener {
    private final ViewModifyProfileController viewModifyProfileController;
    private final ViewProfileViewModel profileViewModel;

    public ModifyProfileListener(ViewModifyProfileController viewModifyProfileController, ViewProfileViewModel profileViewModel){
        this.viewModifyProfileController = viewModifyProfileController;
        this.profileViewModel = profileViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            viewModifyProfileController.execute(profileViewModel.getState().getUser());
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

package view.profile;

import interface_adapter.profile.ManageProduct.ManageProductController;
import interface_adapter.profile.ModifyProfile.ModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserProfileView extends JFrame implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile view";
    private final ViewProfileViewModel viewModel;
    private final ModifyProfileController modifyProfileController;
    private final ManageProductController manageProductController;
    private final ViewProfileController viewProfileController;


    private JTextField studentNumberViewField = new JTextField(20);
    private JTextField studentNameViewField = new JTextField(20);
    private JTextField studentEmailViewField = new JTextField(20);
    private JTextField studentRatingViewField = new JTextField(20);

    public UserProfileView(ViewProfileViewModel profileViewModel, ModifyProfileController modifyProfileController, ManageProductController manageProductController, ViewProfileController viewProfileController){
        this.viewModel = profileViewModel;
        this.modifyProfileController = modifyProfileController;
        this.manageProductController = manageProductController;
        this.viewProfileController = viewProfileController;
        viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(profileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        ProfileLabelTextPanel userNameInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERNAME_LABEL), studentNameViewField);
        ProfileLabelTextPanel userIDInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERID_LABEL), studentNumberViewField);
        ProfileLabelTextPanel userEmail = new ProfileLabelTextPanel(new JLabel(profileViewModel.USEREMAIL_LABEL), studentEmailViewField);
        ProfileLabelTextPanel userRating = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERRATING_LABLE), studentRatingViewField);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(userNameInfo);
        this.add(userIDInfo);
        this.add(userEmail);
        this.add(userRating);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewProfileState state = (ViewProfileState) evt.getNewValue();
    }
}


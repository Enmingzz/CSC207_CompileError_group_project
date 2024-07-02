package view.profile;

import interface_adapter.profile.ManageProduct.ManageProductController;
import interface_adapter.profile.ModifyProfile.ModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import view.profile.ProfileListener.ManageProductListener;
import view.profile.ProfileListener.ModifyProfileListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProfileView extends JFrame implements ActionListener, PropertyChangeListener {
    public final String viewName = "profile view";
    private final ManageProductController manageProductController;
    private final ModifyProfileController modifyProfileController;
    private final ViewProfileViewModel viewModel;
    private final JButton manageProduct;
    private final JButton modifyName;
    private final JButton modifyPassword;

    private JTextField studentNumberViewField = new JTextField(20);
    private JTextField studentNameViewField = new JTextField(20);
    private JTextField studentEmailViewField = new JTextField(20);
    private JTextField studentRatingViewField = new JTextField(20);

    public ProfileView (ManageProductController manageProductController, ModifyProfileController modifyProfileController, ViewProfileViewModel profileViewModel){
        this.manageProductController = manageProductController;
        this.modifyProfileController = modifyProfileController;
        this.viewModel = profileViewModel;
        viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(profileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        ProfileLabelTextPanel userNameInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERNAME_LABEL), studentNameViewField);
        ProfileLabelTextPanel userIDInfo = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERID_LABEL), studentNumberViewField);
        ProfileLabelTextPanel userEmail = new ProfileLabelTextPanel(new JLabel(profileViewModel.USEREMAIL_LABEL), studentEmailViewField);
        ProfileLabelTextPanel userRating = new ProfileLabelTextPanel(new JLabel(profileViewModel.USERRATING_LABLE), studentRatingViewField);

        JPanel buttons = new JPanel();
        manageProduct = new JButton(profileViewModel.MANAGEPRODUCT_BUTTONLABEL);
        buttons.add(manageProduct);
        modifyName = new JButton(profileViewModel.MODIFYNAME_BUTTON_LABEL);
        buttons.add(modifyName);
        modifyPassword = new JButton(profileViewModel.MODIFYPASSWORD_BUTTON_LABEL);
        buttons.add(modifyPassword);

        manageProduct.addActionListener(new ManageProductListener(manageProductController, viewModel));
        modifyName.addActionListener(new ModifyProfileListener(modifyProfileController, viewModel));
        modifyPassword.addActionListener(new ModifyProfileListener(modifyProfileController, viewModel));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(userNameInfo);
        this.add(userIDInfo);
        this.add(userEmail);
        this.add(userRating);
        this.add(buttons);

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

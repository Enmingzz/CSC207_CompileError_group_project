package view.profile;

import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import view.profile.ProfileListener.ManageProductListener;
import view.profile.ProfileListener.ModifyProfileListener;
import view.profile.ProfileListener.ProfileLabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProfileView extends JFrame implements PropertyChangeListener {
    public final String viewName = "Profile View";
    private final ManageProductController manageProductController;
    private final ModifyProfileController modifyProfileController;
    private final ViewProfileViewModel viewModel;
    private final JButton manageProduct;
    private final JButton modifyName;
    private final JButton modifyPassword;

    private JLabel studentNumberViewField = new JLabel();
    private JLabel studentNameViewField = new JLabel();
    private JLabel studentEmailViewField = new JLabel();
    private JLabel studentRatingViewField = new JLabel();

    public ProfileView (ManageProductController manageProductController, ModifyProfileController modifyProfileController, ViewProfileViewModel profileViewModel){
        this.manageProductController = manageProductController;
        this.modifyProfileController = modifyProfileController;
        this.viewModel = profileViewModel;
        viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(profileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        studentNumberViewField.setText(viewModel.getState().getUser().getStudentNumber());
        studentNameViewField.setText(viewModel.getState().getUser().getName());
        studentEmailViewField.setText(viewModel.getState().getUser().getEmail());
        studentRatingViewField.setText(String.valueOf(viewModel.getState().getUser().getUserRating()));

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
    public void propertyChange(PropertyChangeEvent evt) {
        ViewProfileState state = (ViewProfileState) evt.getNewValue();
        viewModel.setState(state);
    }
}

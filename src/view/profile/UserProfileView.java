package view.profile;

import interface_adapter.login.LoginController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.SignupController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserProfileView extends JFrame implements PropertyChangeListener {
    public final String viewName = "UserProfile View";
    private final ViewProfileViewModel viewModel;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;
    private final LoginController loginController;
    private final SignupController signupController;



    private JTextField studentNumberViewField = new JTextField(20);
    private JTextField studentNameViewField = new JTextField(20);
    private JTextField studentEmailViewField = new JTextField(20);
    private JTextField studentRatingViewField = new JTextField(20);

    public UserProfileView(MainPageController mainPageController,
                           ShoppingCartController shoppingCartController,
                           ViewProfileViewModel profileViewModel, ViewProfileController
                                   viewProfileController,  LoginController loginController,
                           SignupController signupController){
        this.viewModel = profileViewModel;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.loginController = loginController;
        this.signupController = signupController;
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(userNameInfo);
        this.add(userIDInfo);
        this.add(userEmail);
        this.add(userRating);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewProfileState state = (ViewProfileState) evt.getNewValue();
    }
}


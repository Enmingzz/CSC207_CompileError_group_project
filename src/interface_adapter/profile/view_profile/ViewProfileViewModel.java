package interface_adapter.profile.view_profile;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewProfileViewModel extends ViewModel {

    private final UserFactory commonUserFactory = new CommonUserFactory();
    public final String TITLE_LABEL = "Profile View";
    public final String USERID_LABEL = "Student ID";
    public final String USERNAME_LABEL = "Name";
    public final String PASSWORD_LABEL = "Password";
    public final String USEREMAIL_LABEL = "UofT Email";
    public final String USERRATING_LABLE = "Rating";

    public final String MANAGEPRODUCT_BUTTONLABEL = "Manage product";
    public final String VIEW_PROFILE_BOTTON_LABEL = "View Profile";
    public final String MODIFYNAME_BUTTON_LABEL = "Modify Name";

    public final String MAIN_BUTTON_LABEL = "Main";
    public final String LOGIN_BUTTON_LABEL = "Login";
    public final String SIGNUP_BUTTON_LABEL = "SignUp";
    public final String SHOPPING_BUTTON_LABEL = "ShoppingCart";
    public final String PROFILE_BUTTON_LABEL = "Profile";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private ViewProfileState state = new ViewProfileState(commonUserFactory);

    public ViewProfileViewModel() {
        super("profile view");
    }

    public ViewProfileState getState() {
        return state;
    }

    public void setState(ViewProfileState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

package interface_adapter.profile.view_profile;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewUserProfileViewModel extends ViewModel {
    private final UserFactory commonUserFactory = new CommonUserFactory();
    public final String TITLE_LABEL = "Profile View";
    public final String USERID_LABEL = "Student ID";
    public final String USERNAME_LABEL = "Name";
    public final String PASSWORD_LABEL = "Password";
    public final String USEREMAIL_LABEL = "UofT Email";
    public final String USERRATING_LABLE = "Rating";

    public final String MANAGEPRODUCT_BUTTONLABEL = "Manage Product";
    public final String VIEW_PROFILE_BOTTON_LABEL = "View Profile";
    public final String MODIFYPROFILE_BUTTON_LABEL = "Modify Profile";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private ViewUserProfileState state = new ViewUserProfileState(commonUserFactory);

    public ViewUserProfileViewModel() {
        super("user profile view");
    }

    public ViewUserProfileState getState() {
        return state;
    }

    public void setState(ViewUserProfileState state) {
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


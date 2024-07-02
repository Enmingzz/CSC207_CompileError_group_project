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
    public final String USEREMAIL_LABEL = "UofT Email";
    public final String USERRATING_LABLE = "Rating";

    public final String MANAGEPRODUCT_BUTTONLABEL = "Manage Product";
    public final String MODIFYPASSWORD_BUTTON_LABEL = "Modify Password";
    public final String MODIFYNAME_BUTTON_LABEL = "Modify Name";
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

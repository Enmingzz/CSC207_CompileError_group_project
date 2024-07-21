package interface_adapter.profile.view_profile;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 * ViewModel for viewing the user's profile, responsible for managing the state and notifying listeners of changes.
 */
public class ViewProfileViewModel extends ViewModel {

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

    private ViewProfileState state = new ViewProfileState(commonUserFactory);
    /**
     * Constructs a {@link ViewProfileViewModel} with the specified view name.
     */
    public ViewProfileViewModel() {
        super("profile view");
    }
    /**
     * Gets the current state of the view profile view model.
     *
     * @return the current state
     */
    public ViewProfileState getState() {
        return state;
    }
    /**
     * Sets the state of the view profile view model.
     *
     * @param state the new state to set
     */
    public void setState(ViewProfileState state) {
        this.state = state;
    }
    /**
     * Fires a property change event to notify listeners of state changes.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    /**
     * Adds a property change listener to listen for state changes.
     *
     * @param listener the listener to add
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

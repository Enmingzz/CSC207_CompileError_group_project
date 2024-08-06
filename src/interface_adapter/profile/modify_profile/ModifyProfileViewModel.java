package interface_adapter.profile.modify_profile;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 * ViewModel for modifying the user's profile, responsible for managing the state and notifying listeners of changes.
 */
public class ModifyProfileViewModel extends ViewModel {
    public final String TITLE_LABEL = "Modify Profile View";
    public final String USERNAME_LABEL = "Enter Name";
    public final String PASSWORD_LABEL = "Enter Password";

    public final String CONFIRM_BUTTON_LABEL = "Confirm";
    public final String BACK_BUTTON_LABEL = "Back";

    private UserFactory userFactory = new CommonUserFactory();

    private ModifyProfileState state = new ModifyProfileState(userFactory);
    /**
     * Constructs a {@link ModifyProfileViewModel} with the specified view name.
     */
    public ModifyProfileViewModel() {
        super("modify profile");
    }
    /**
     * Sets the state of the modify profile view model.
     *
     * @param state the new state to set
     */
    public void setState(ModifyProfileState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    /**
     * Fires a property change event to notify listeners of state changes.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    /**
     * Adds a property change listener to listen for state changes.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    /**
     * Gets the current state of the modify profile view model.
     *
     * @return the current state
     */
    public ModifyProfileState getState() {
        return state;
    }
}

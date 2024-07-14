package interface_adapter.profile.modify_profile;

import interface_adapter.ViewModel;
import interface_adapter.signup.SignupState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModifyProfileViewModel extends ViewModel {

    private ModifyProfileState state;

    public ModifyProfileViewModel() {
        super("modify profile");
    }

    public void setState(ModifyProfileState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ModifyProfileState getState() {
        return state;
    }

}

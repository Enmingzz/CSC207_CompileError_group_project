package interface_adapter.profile.modify_profile;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewModel;
import interface_adapter.profile.view_profile.ViewProfileState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModifyProfileViewModel extends ViewModel {

    public final String TITLE_LABEL = "Modify Profile";
    public final String USERNAME_LABEL = "Enter Name";
    public final String PASSWORD_LABEL = "Enter Password";
    public final String BUTTON_LABEL = "Confirm";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private ModifyProfileState state = new ModifyProfileState();

    public ModifyProfileViewModel() {
        super("modify profile");
    }

    public ModifyProfileState getState() {
        return state;
    }

    public void setState(ModifyProfileState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

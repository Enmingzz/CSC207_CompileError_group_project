package interface_adapter.profile.modify_profile;

import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewModel;
import interface_adapter.signup.SignupState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModifyProfileViewModel extends ViewModel {
    public final String TITLE_LABEL = "Modify Profile View";
    public final String USERNAME_LABEL = "Enter Name";
    public final String PASSWORD_LABEL = "Enter Password";

    public final String CONFIRM_BUTTON_LABEL = "Confirm";
    public final String BACK_BUTTON_LABEL = "Back";

    private UserFactory userFactory = new CommonUserFactory();

    private ModifyProfileState state = new ModifyProfileState(userFactory);

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

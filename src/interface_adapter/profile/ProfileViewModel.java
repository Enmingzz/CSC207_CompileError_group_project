package interface_adapter.profile;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class ProfileViewModel extends ViewModel {

    private final UserFactory commonUserFactory = new CommonUserFactory();

    private ProfileState state = new ProfileState(commonUserFactory);

    public ProfileViewModel() {
        super("profile view");
    }

    @Override
    public void firePropertyChanged() {

    }

    public ProfileState getState() {
        return state;
    }

    public void setState(ProfileState state) {
        this.state = state;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}

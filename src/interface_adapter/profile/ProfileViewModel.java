package interface_adapter.profile;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class ProfileViewModel extends ViewModel {

    private final UserFactory commonUserFactory = new CommonUserFactory();

    private final ProfileState state = new ProfileState(commonUserFactory);

    public ProfileViewModel() {
        super("profile view");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}

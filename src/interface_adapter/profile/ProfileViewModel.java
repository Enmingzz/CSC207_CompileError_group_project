package interface_adapter.profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class ProfileViewModel extends ViewModel {

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

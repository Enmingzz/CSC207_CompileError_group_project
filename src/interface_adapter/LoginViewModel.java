package interface_adapter;

import java.beans.PropertyChangeListener;

public class LoginViewModel extends ViewModel {

    public LoginViewModel() {
        super("LoginViewModel");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}

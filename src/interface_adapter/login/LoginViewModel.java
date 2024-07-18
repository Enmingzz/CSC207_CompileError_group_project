package interface_adapter.login;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class for the login view.
 * Holds the state of the login form and provides methods to notify listeners of state changes.
 */
public class LoginViewModel extends ViewModel {

    public final String TITLE_LABEL = "Log In View";
    public final String NUMBER_LABEL = "Enter your student number";
    public final String PASSWORD_LABEL = "Enter password";

    public final String LOGIN_BUTTON_LABEL = "Log in";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private LoginState state = new LoginState();

    /**
     * Constructs a LoginViewModel with the default view model name.
     */
    public LoginViewModel() {
        super("log in");
    }

    /**
     * Sets the current state of the login form.
     *
     * @param state the new login state
     */
    public void setState(LoginState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event to notify listeners of changes in the login state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to this view model.
     *
     * @param listener the property change listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Returns the current state of the login form.
     *
     * @return the current login state
     */
    public LoginState getState() {
        return state;
    }
}

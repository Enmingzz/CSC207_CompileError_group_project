package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class for the signup view.
 * Holds the state of the signup form and provides methods to notify listeners of state changes.
 */

public class SignupViewModel extends ViewModel {
    public final String TITLE_LABEL = "Sign Up View";
    public final String USERNAME_LABEL = "Choose username";
    public final String PASSWORD_LABEL = "Choose password";
    public final String REPEAT_PASSWORD_LABEL = "Enter password again";
    public final String EMAIL_LABEL = "Enter email";
    public final String STUDENT_NUMBER_LABEL = "Enter student number";
    public final String VERIFICATION_LABEL = "Enter verification code";

    public final String SIGNUP_BUTTON_LABEL = "Sign up";
    public final String SEND_EMAIL_VERIFICATION_LABEL = "send";
    public final String EMAIL_AT = "@mail.utoronto.ca";

    private SignupState state = new SignupState();

    /**
     * Constructs a SignupViewModel with the default view model name.
     */

    public SignupViewModel() {
        super("SignUpViewModel");
    }

    /**
     * Sets the current state of the signup form.
     *
     * @param state the new signup state
     */

    public void setState(SignupState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event to notify listeners of changes in the signup state.
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
     * Returns the current state of the signup form.
     *
     * @return the current signup state
     */

    public SignupState getState() {
        return state;
    }
}

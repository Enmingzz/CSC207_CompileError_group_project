package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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

    private SignupState state = new SignupState();

    public SignupViewModel() {
        super("SignUpViewModel");
    }

    public void setState(SignupState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SignupState getState() {
        return state;
    }
}

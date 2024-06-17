package interface_adapter;

import java.beans.PropertyChangeListener;

public class LoginViewModel extends ViewModel {

    public final String TITLE_LABEL = "Sign Up View";
    public final String USERNAME_LABEL = "Choose username";
    public final String PASSWORD_LABEL = "Choose password";
    public final String REPEAT_PASSWORD_LABEL = "Enter password again";
    public final String FIRST_NAME_LABEL = "Enter first name";
    public final String LAST_NAME_LABEL = "Enter last name";
    public final String EMAIL_LABEL = "Enter email";
    public final String UTORID_LABEL = "Enter UTORID";
    public final String

    public final String SIGNUP_BUTTON_LABEL = "Sign up";

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

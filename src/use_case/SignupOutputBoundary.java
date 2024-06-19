package use_case;

import interface_adapter.LoginState;
import interface_adapter.SignupState;

public interface SignupOutputBoundary {

    public void presentSuccessfulView(SignupOutputData response);

    public void presentFailedView(String error);
}

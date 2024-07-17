package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

/**
 * Presenter class for the signup process.
 * Implements the SignupOutputBoundary interface and updates the view models and view manager based on the response.
 */
public class SignupPresenter implements SignupOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a SignupPresenter with the given view manager model, signup view model, and login view model.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     * @param loginViewModel   the login view model
     */
    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Presents a successful signup view.
     * Updates the login state and view manager based on the successful signup response.
     *
     * @param response the successful signup response data
     */
    @Override
    public void presentSuccessfulView(SignupOutputData response) {
        SignupState signupState = signupViewModel.getState();
        LoginState loginState = loginViewModel.getState();
        loginState.setStudentNumber(response.getUser().getName());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();
        viewManagerModel.setActiveView("test view");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Presents a failed signup view.
     * Updates the signup state with the error message from the failed signup response.
     *
     * @param response the failed signup response data
     */
    @Override
    public void presentFailedView(SignupOutputData response) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(response.getError());
        signupViewModel.firePropertyChanged();
    }

}

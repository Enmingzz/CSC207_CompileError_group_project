package interface_adapter.login;

import interface_adapter.main_page.MainPageState;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * Presenter class for the login process.
 * Implements the LoginOutputBoundary interface to handle the login output data and update the view models and view manager.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final MainPageViewModel mainPageViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a LoginPresenter with the given view manager model, login view model, and main page view model.
     *
     * @param viewManagerModel the view manager model
     * @param loginViewModel the login view model
     * @param mainPageViewModel the main page view model
     */
    public LoginPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel) {
        this.loginViewModel = loginViewModel;
        this.mainPageViewModel = mainPageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares a successful view for the login process.
     * Updates the main page state with the user information from the response and changes the active view.
     *
     * @param response the output data for the successful login
     */
    @Override
    public void prepareSuccessfulView(LoginOutputData response) {
        LoginState loginState = loginViewModel.getState();
        MainPageState mainPageState = mainPageViewModel.getState();
        mainPageState.setUser(response.getUser());
        mainPageViewModel.setState(mainPageState);

        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();
        mainPageViewModel.firePropertyChanged();
        mainPageViewModel.initFirePropertyChanged();
        viewManagerModel.setActiveView(mainPageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares a failed view for the login process.
     * Updates the login state with the error message and fires a property change event.
     *
     * @param error the error message for the failed login
     */
    @Override
    public void prepareFailedView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setStudentNumberError(error);
        loginState.setIsChanged(true);

        loginViewModel.firePropertyChanged();
        loginState.setIsChanged(false);
    }
}

package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.profile.view_profile.ViewProfileState;
import use_case.login.ViewLoginPageOutputBoundary;
import use_case.login.ViewLoginPageOutputData;
import use_case.signup.SignupOutputData;

/**
 * Presenter class for viewing the login page.
 * Implements the ViewLoginPageOutputBoundary interface to handle the output data and update the view model and view manager.
 */
public class ViewLoginPagePresenter implements ViewLoginPageOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewLoginPagePresenter with the given login view model and view manager model.
     *
     * @param loginViewModel the login view model
     * @param viewManagerModel the view manager model
     */
    public ViewLoginPagePresenter(LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful display of the login page.
     * Fires a property change event on the view manager to notify listeners of the change.
     *
     * @param viewLoginPageOutputData the output data for displaying the login page
     */
    @Override
    public void prepareSuccessfulView(ViewLoginPageOutputData viewLoginPageOutputData) {
        //TODO need to implement this method

        System.out.println("ViewLoginPagePresenter called");

        LoginState state = loginViewModel.getState();

        loginViewModel.setState(state);

        loginViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

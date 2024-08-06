package interface_adapter.signup.view_signup_page;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.signup.SignupViewModel;
import use_case.signup.ViewSignupPageOutputBoundary;
import use_case.signup.ViewSignupPageOutputData;

/**
 * Presenter class for preparing the view of the signup page.
 * Implements the ViewSignupPageOutputBoundary interface to handle the output data and update the view manager and view model.
 */
public class ViewSignupPagePresenter implements ViewSignupPageOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;

    /**
     * Constructs a ViewSignupPagePresenter with the given view manager model and signup view model.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     */
    public ViewSignupPagePresenter(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
    }

    /**
     * Prepares a successful view for the signup page.
     * Updates the view manager to set the active view to "sign up" and fires a property change event.
     *
     * @param viewSignupPageOutputData the output data for the signup page view
     */
    @Override
    public void prepareSuccessfulView(ViewSignupPageOutputData viewSignupPageOutputData) {
        viewManagerModel.setActiveView("sign up");
        viewManagerModel.firePropertyChanged();
    }
}

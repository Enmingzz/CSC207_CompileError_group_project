package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import use_case.signup.ViewSignupPageOutputBoundary;
import use_case.signup.ViewSignupPageOutputData;

public class ViewSignupPagePresenter implements ViewSignupPageOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;

    public ViewSignupPagePresenter(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessfulView(ViewSignupPageOutputData viewSignupPageOutputData){
        viewManagerModel.setActiveView("sign up");
        viewManagerModel.firePropertyChanged();
    }
}

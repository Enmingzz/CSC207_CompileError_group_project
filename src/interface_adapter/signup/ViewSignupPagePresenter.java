package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import use_case.Signup.ViewSignupPageOutputBoundary;
import use_case.Signup.ViewSignupPageOutputData;

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

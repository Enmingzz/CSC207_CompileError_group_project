package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import use_case.Signup.EmailVerificationOutputBoundary;
import use_case.Signup.EmailVerificationOutputData;

public class EmailVerificationPresenter implements EmailVerificationOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;

    public EmailVerificationPresenter(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
    }

    public void prepareView(EmailVerificationOutputData emailVerificationOutputData){
        SignupState signupState = signupViewModel.getState();
        signupState.setGeneratedVerificationCode(emailVerificationOutputData.getVerificationCode());
        signupViewModel.setState(signupState);
        //System.out.println(signupViewModel.getState().hashCode());
        //System.out.println(signupViewModel.getState().getGeneratedVerificationCode());
    }
}

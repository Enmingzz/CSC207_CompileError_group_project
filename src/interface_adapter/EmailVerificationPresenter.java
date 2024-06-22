package interface_adapter;

import use_case.EmailVerificationOutputBoundary;
import use_case.EmailVerificationOutputData;

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

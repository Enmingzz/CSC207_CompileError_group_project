package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import use_case.signup.EmailVerificationOutputBoundary;
import use_case.signup.EmailVerificationOutputData;

/**
 * Presenter class for email verification during the signup process.
 * Implements the EmailVerificationOutputBoundary interface to handle the output data and update the view manager and view model.
 */
public class EmailVerificationPresenter implements EmailVerificationOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;

    /**
     * Constructs an EmailVerificationPresenter with the given view manager model and signup view model.
     *
     * @param viewManagerModel the view manager model
     * @param signupViewModel  the signup view model
     */
    public EmailVerificationPresenter(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
    }

    /**
     * Prepares the view for email verification.
     * Updates the signup state with the generated verification code from the output data.
     *
     * @param emailVerificationOutputData the output data for email verification
     */
    public void prepareView(EmailVerificationOutputData emailVerificationOutputData) {
        SignupState signupState = signupViewModel.getState();
        signupState.setGeneratedVerificationCode(emailVerificationOutputData.getVerificationCode());
        signupViewModel.setState(signupState);
    }
}

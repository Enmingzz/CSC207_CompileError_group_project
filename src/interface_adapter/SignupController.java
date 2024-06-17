package interface_adapter;

import use_case.SignupInputBoundary;
import use_case.SignupInputData;

public class SignupController {
    final SignupInputBoundary SignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.SignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password, String repeatPassword, String emailAddress, String verificationCode) {
        SignupInputData signupInputData = new SignupInputData(username, password, repeatPassword, emailAddress, verificationCode);

        SignupUseCaseInteractor.execute(signupInputData);
    }
}
